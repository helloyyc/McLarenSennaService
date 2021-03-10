package aiot.mclaren.senna.host.controller;


import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.service.IThingConfigService;
import aiot.mclaren.senna.sdk.api.ThingConfigApi;
import aiot.mclaren.senna.sdk.dto.ThingConfigBody;
import aiot.mclaren.senna.sdk.dto.ThingConfigDTO;
import aiot.mclaren.senna.sdk.request.ThingConfigDetailQuery;
import aiot.mclaren.senna.sdk.request.ThingConfigQuery;
import aiot.mclaren.senna.sdk.response.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-03-09
 */
@RestController
public class ThingConfigController implements ThingConfigApi {

    @Autowired
    private IThingConfigService thingConfigService;

    @Override
    public DataResponse<ThingConfigDTO> create(ThingConfigBody body) {
        return DataResponse.success(thingConfigService.upsert(body));
    }

    @Override
    public DataResponse<PageList<ThingConfigDTO>> listPage(ThingConfigQuery query) {
        return DataResponse.success(thingConfigService.queryPage(query));
    }

    @Override
    public DataResponse<ThingConfigDTO> getDetail(ThingConfigDetailQuery query) {
        return DataResponse.success(thingConfigService.queryDetail(query));
    }
}

