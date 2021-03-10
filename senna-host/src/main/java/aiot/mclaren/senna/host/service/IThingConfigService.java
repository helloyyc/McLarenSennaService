package aiot.mclaren.senna.host.service;

import aiot.mclaren.senna.model.entity.ThingConfig;
import aiot.mclaren.senna.sdk.dto.ThingConfigBody;
import aiot.mclaren.senna.sdk.dto.ThingConfigDTO;
import aiot.mclaren.senna.sdk.request.ThingConfigDetailQuery;
import aiot.mclaren.senna.sdk.request.ThingConfigQuery;
import aiot.mclaren.senna.sdk.response.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-03-09
 */
public interface IThingConfigService extends IService<ThingConfig> {

    ThingConfigDTO upsert(ThingConfigBody body);

    PageList<ThingConfigDTO> queryPage(ThingConfigQuery query);

    ThingConfigDTO queryDetail(ThingConfigDetailQuery query);
}
