package aiot.mclaren.senna.host.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.function.Supplier;

import aiot.mclaren.commons.oss.OssPutResult;
import aiot.mclaren.commons.oss.OssService;
import aiot.mclaren.senna.host.common.OssKeyUtil;
import aiot.mclaren.senna.host.mapstruct.ThingConfigConverter;
import aiot.mclaren.senna.model.entity.ThingConfig;
import aiot.mclaren.senna.host.mapper.ThingConfigMapper;
import aiot.mclaren.senna.host.service.IThingConfigService;
import aiot.mclaren.senna.model.enums.ConfigScopeEnum;
import aiot.mclaren.senna.sdk.dto.ThingConfigBody;
import aiot.mclaren.senna.sdk.dto.ThingConfigDTO;
import aiot.mclaren.senna.sdk.exception.ApiException;
import aiot.mclaren.senna.sdk.request.ThingConfigQuery;
import aiot.mclaren.senna.sdk.response.ErrorCode;
import aiot.mclaren.senna.sdk.response.PageList;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-03-09
 */
@Service
public class ThingConfigServiceImpl extends ServiceImpl<ThingConfigMapper, ThingConfig> implements IThingConfigService {

    @Autowired
    private OssService ossService;

    @Transactional
    @Override
    public ThingConfigDTO upsert(ThingConfigBody body) {

        ConfigScopeEnum scope = ConfigScopeEnum.PRODUCT;
        UpdateWrapper<ThingConfig> wrapper = new UpdateWrapper<>();
        wrapper.eq("product_key", body.getProductKey()).eq("status", 1);

        ThingConfig config = new ThingConfig();
        if (!StringUtils.isEmpty(body.getDeviceName())) {
            config.setDeviceName(body.getDeviceName());
            scope = ConfigScopeEnum.DEVICE;
            wrapper.eq("device_name", body.getDeviceName());
        }

        wrapper.eq("scope", scope.getValue());
        wrapper.set("status", 0);
        this.update(wrapper);

        config.setConfigId(IdUtil.fastSimpleUUID());
        config.setProductKey(body.getProductKey());
        config.setScope(scope.getValue());
        config.setConfigFormat("JSON");
        config.setSignMethod("Sha256");

        String configContent = body.getConfigContent();
        config.setSign(SecureUtil.sha256(configContent));
        config.setConfigSize((long)configContent.getBytes(StandardCharsets.UTF_8).length);
        config.setStatus(1);
        String key = OssKeyUtil.getKey(body.getProductKey(), "thingConfig");
        OssPutResult ossPutResult = ossService.uploadJson(key, configContent);
        config.setOssPath(key);
        config.setOssUrl(ossPutResult.getUrl());
        config.setOssVersionId(ossPutResult.getVersionId());
        boolean save = this.save(config);
        if (!save) {
            throw new ApiException(ErrorCode.DATABASE_OPERATION_EXCEPTION);
        }
        return ThingConfigConverter.INSTANCE.toThingConfigDTO(config);
    }

    @Override
    public PageList<ThingConfigDTO> queryPage(ThingConfigQuery query) {
        QueryWrapper<ThingConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_key", query.getProductKey());

        if (!StringUtils.isEmpty(query.getDeviceName())) {
            queryWrapper.eq("device_name", query.getDeviceName());
        }

        if (!StringUtils.isEmpty(query.getScope())) {
            queryWrapper.eq("scope", query.getScope());
        }

        queryWrapper.eq("status", Optional.ofNullable(query.getStatus()).orElse(1));
        return ThingConfigConverter.INSTANCE.toThingConfigDTOPages(page(query.toPage(), queryWrapper));
    }

    @Override
    public ThingConfigDTO queryDetail(ThingConfigQuery query) {
        QueryWrapper<ThingConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_key", query.getProductKey())
            .eq("scope", query.getScope())
            .eq("status", query.getStatus());
        if (ConfigScopeEnum.DEVICE.getValue().equals(query.getScope())) {
            queryWrapper.eq("device_name", query.getDeviceName());
        }
        return ThingConfigConverter.INSTANCE.toThingConfigDTO(this.getOne(queryWrapper));
    }

}
