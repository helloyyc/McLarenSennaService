package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.common.SecurityUtils;
import aiot.mclaren.senna.host.exception.ApiException;
import aiot.mclaren.senna.host.mapstruct.DeviceConverter;
import aiot.mclaren.senna.host.service.IProductService;
import aiot.mclaren.senna.model.entity.Device;
import aiot.mclaren.senna.host.mapper.DeviceMapper;
import aiot.mclaren.senna.host.service.IDeviceService;
import aiot.mclaren.senna.model.entity.Product;
import aiot.mclaren.senna.model.type.DeviceStatus;
import aiot.mclaren.senna.model.type.SecureMode;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.DeviceBody;
import aiot.mclaren.senna.sdk.request.DeviceQuery;
import aiot.mclaren.senna.sdk.response.ErrorCode;
import aiot.mclaren.senna.sdk.response.SimplePage;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {
    @Autowired
    private IProductService productService;

    @Override
    public DataResponse<DeviceDTO> create(DeviceBody body) {
        Product product = productService.getByProductKey(body.getProductKey());
        /* 产品是否存在 */
        if (product == null) {
            throw new ApiException(ErrorCode.PRODUCT_NOT_FOUND);
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
        String hmacKey;
        if (SecureMode.ONE_PRODUCT_ONE_SECRET.getId() == product.getSecureMode()) {
            hmacKey = product.getProductSecret();
        } else if (SecureMode.ONE_MACHINE_ONE_SECRET.getId() == product.getSecureMode()) {
            hmacKey = deviceSecret;
        } else {
            throw new ApiException(ErrorCode.PRODUCT_SECURE_MODE_NOT_SUPPORT);
        }
        String salt = SecurityUtils.getSalt();
        device.setSalt(salt);
        device.setPassword(SecureUtil.sha256(SecureUtil.hmacSha1(hmacKey).digestHex(deviceName) + salt));
        /* 默认未激活 */
        device.setDeviceStatus(DeviceStatus.UNACTIVE.getId());
        boolean save = this.save(device);
        if (!save) {
            throw new ApiException(ErrorCode.DATABASE_OPERATION_EXCEPTION);
        }
        return DataResponse.success(DeviceConverter.INSTANCE.toDeviceDTO(device));
    }

    @Override
    public DataResponse<SimplePage<DeviceDTO>> selectPage(DeviceQuery query) {
        return null;
    }

    @Override
    public Device getByDeviceNameAndProductKey(String deviceName, String productKey) {
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("device_name", deviceName).eq("product_key", productKey);
        return this.getOne(queryWrapper);
    }

}
