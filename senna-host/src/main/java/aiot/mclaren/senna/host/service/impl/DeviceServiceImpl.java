package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.common.SecurityUtils;
import aiot.mclaren.senna.sdk.exception.ApiException;
import aiot.mclaren.senna.host.mapstruct.DeviceConverter;
import aiot.mclaren.senna.host.service.IDeviceAclService;
import aiot.mclaren.senna.host.service.IProductService;
import aiot.mclaren.senna.model.entity.Device;
import aiot.mclaren.senna.host.mapper.DeviceMapper;
import aiot.mclaren.senna.host.service.IDeviceService;
import aiot.mclaren.senna.model.entity.Product;
import aiot.mclaren.senna.model.enums.DeviceEnableEnum;
import aiot.mclaren.senna.model.enums.DeviceStatusEnum;
import aiot.mclaren.senna.model.enums.SecureModeEnum;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.*;
import aiot.mclaren.senna.sdk.response.ErrorCode;
import aiot.mclaren.senna.sdk.response.PageList;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {
    @Autowired
    private IProductService productService;

    @Autowired
    private IDeviceAclService deviceAclService;

    @Autowired
    private DeviceMapper deviceMapper;

    @Transactional
    @Override
    public DataResponse<DeviceDTO> create(DeviceBody body) {
        Product product = productService.getByProductKey(body.getProductKey());
        /* 产品是否存在 */
        if (product == null) {
            throw new ApiException(ErrorCode.PRODUCT_NOT_FOUND);
        }

        /* 校验产品秘钥方式合法性 */
        if (product.getSecureMode() != SecureModeEnum.ONE_PRODUCT_ONE_SECRET.getId()
            && product.getSecureMode() != SecureModeEnum.ONE_MACHINE_ONE_SECRET.getId()) {
            throw new ApiException(ErrorCode.PRODUCT_SECURE_MODE_NOT_SUPPORT);
        }

        /* 当前设备名是否重复 */
        if (this.getByDeviceNameAndProductKey(body.getDeviceName(), body.getProductKey()) != null) {
            throw new ApiException(ErrorCode.DEVICE_NAME_EXISTS);
        }

        Device device = DeviceConverter.INSTANCE.toDevice(body);
        String productKey = product.getProductKey();
        String deviceName = device.getDeviceName();

        /* 需要5ms左右*/
        device.setIotId(IdUtil.fastSimpleUUID());
        /* 需要700ms左右*/
        /*device.setIotId(IdUtil.objectId());*/
        device.setIsSuperuser(false);
        device.setUsername(deviceName + "&" + productKey);

        String deviceSecret = SecurityUtils.getSecretKey(productKey, deviceName);
        device.setDeviceSecret(deviceSecret);

        /* 根据产品安全模式获取不同的加密秘钥 */
        String hmacKey =
            SecureModeEnum.ONE_PRODUCT_ONE_SECRET.getId() == product.getSecureMode() ? product.getProductSecret() :
                deviceSecret;
        String salt = SecurityUtils.getSalt();
        device.setSalt(salt);
        device.setPassword(SecureUtil.sha256(SecureUtil.hmacSha1(hmacKey).digestHex(deviceName) + salt));
        /* 默认未激活 */
        device.setDeviceStatus(DeviceStatusEnum.UNACTIVE.getCode());
        device.setEnable(DeviceEnableEnum.ENABLE.getCode());
        boolean save = this.save(device);
        if (!save) {
            throw new ApiException(ErrorCode.DATABASE_OPERATION_EXCEPTION);
        }

        save = deviceAclService
            .initNewDeviceDefaultAcl(new DeviceDefaultAclBody(productKey, deviceName, device.getUsername()));
        if (!save) {
            throw new ApiException(ErrorCode.DATABASE_OPERATION_EXCEPTION);
        }

        return DataResponse.success(DeviceConverter.INSTANCE.toDeviceDTO(device));
    }

    @Transactional
    @Override
    public DataResponse<List<DeviceDTO>> batchCreate(BatchDeviceBody body) {
        Product product = productService.getByProductKey(body.getProductKey());
        /* 产品是否存在 */
        if (product == null) {
            throw new ApiException(ErrorCode.PRODUCT_NOT_FOUND);
        }

        /* 校验产品秘钥方式合法性 */
        if (product.getSecureMode() != SecureModeEnum.ONE_PRODUCT_ONE_SECRET.getId()
            && product.getSecureMode() != SecureModeEnum.ONE_MACHINE_ONE_SECRET.getId()) {
            throw new ApiException(ErrorCode.PRODUCT_SECURE_MODE_NOT_SUPPORT);
        }

        List<BatchDeviceBody.BatchDeviceItem> dataList = body.getDevices();
        QueryWrapper<Device> wrapper =
            new QueryWrapper<Device>().eq("product_key", product.getProductKey()).and(itemWrapper -> {
                for (BatchDeviceBody.BatchDeviceItem deviceItem : dataList) {
                    itemWrapper.eq("device_name", deviceItem.getDeviceName()).or();
                }
            }).select("device_name");
        List<String> existsList =
            deviceMapper.selectList(wrapper).stream().map(Device::getDeviceName).collect(Collectors.toList());
        if (existsList.size() > 0) {
            Map<String, Object> errors = new HashMap<>();
            errors.put("deviceNameExists", existsList);
            throw new ApiException(ErrorCode.ARGUMENT_ILLEGAL, errors);
        }

        List<Device> devices = new ArrayList<>();
        String productKey = product.getProductKey();
        for (BatchDeviceBody.BatchDeviceItem deviceItem : dataList) {
            Device device = DeviceConverter.INSTANCE.toDevice(deviceItem);
            String deviceName = device.getDeviceName();

            device.setProductKey(productKey);
            /* 需要5ms左右*/
            device.setIotId(IdUtil.fastSimpleUUID());
            device.setIsSuperuser(false);
            device.setUsername(deviceName + "&" + productKey);

            String deviceSecret = SecurityUtils.getSecretKey(productKey, deviceName);
            device.setDeviceSecret(deviceSecret);

            /* 根据产品安全模式获取不同的加密秘钥 */
            String hmacKey =
                SecureModeEnum.ONE_PRODUCT_ONE_SECRET.getId() == product.getSecureMode() ? product.getProductSecret() :
                    deviceSecret;
            String salt = SecurityUtils.getSalt();
            device.setSalt(salt);
            device.setPassword(SecureUtil.sha256(SecureUtil.hmacSha1(hmacKey).digestHex(deviceName) + salt));
            /* 默认未激活 */
            device.setDeviceStatus(DeviceStatusEnum.UNACTIVE.getCode());
            device.setEnable(DeviceEnableEnum.ENABLE.getCode());
            devices.add(device);
        }
        boolean save = this.saveBatch(devices);
        if (!save) {
            throw new ApiException(ErrorCode.DATABASE_OPERATION_EXCEPTION);
        }

        save = deviceAclService.initMultiNewDeviceDefaultAcl(devices.stream().map(
            device -> new DeviceDefaultAclBody(device.getProductKey(), device.getDeviceName(), device.getUsername()))
            .collect(Collectors.toList()));
        if (!save) {
            throw new ApiException(ErrorCode.DATABASE_OPERATION_EXCEPTION);
        }
        return DataResponse.success(DeviceConverter.INSTANCE.toDeviceDTOs(devices));
    }

    @Override
    public DataResponse<PageList<DeviceDTO>> queryPage(DeviceQuery query) {
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(query.getDeviceName())) {
            queryWrapper.like("device_name", query.getDeviceName());
        }
        if (!StringUtils.isEmpty(query.getNickName())) {
            queryWrapper.like("nick_name", query.getNickName());
        }
        return DataResponse.success(DeviceConverter.INSTANCE.toDeviceDTOPages(page(query.toPage(), queryWrapper)));
    }

    @Override
    public Device getByDeviceNameAndProductKey(String deviceName, String productKey) {
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("device_name", deviceName).eq("product_key", productKey);
        return this.getOne(queryWrapper);
    }

    @Override
    public DataResponse<Boolean> updateEnableStatus(DeviceEnableBody body, DeviceEnableEnum enable) {
        UpdateWrapper<Device> wrapper = new UpdateWrapper<>();
        wrapper.eq("product_key", body.getProductKey()).eq("device_name", body.getDeviceName())
            .set("enable", enable.getCode());
        return DataResponse.success(update(wrapper));
    }

    @Override
    public DataResponse<Boolean> updateDeviceStatus(DeviceStatusBody body) {
        Device device = this.getByDeviceNameAndProductKey(body.getDeviceName(), body.getProductKey());
        if (device == null) {
            throw new ApiException(ErrorCode.DEVICE_NOT_FOUND);
        }

        if (device.getActiveDt() == null) {
            device.setActiveDt(LocalDateTimeUtil.of(body.getLastTime()));
        }
        device.setDeviceStatus(DeviceStatusEnum.valueOf(body.getStatus()).getCode());
        device.setIpAddress(body.getIpAddress());
        device.setOnlineDt(LocalDateTimeUtil.of(body.getLastTime()));
        return DataResponse.success(this.updateById(device));
    }

}
