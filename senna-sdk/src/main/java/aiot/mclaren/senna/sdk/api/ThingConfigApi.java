package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.sdk.dto.ThingConfigBody;
import aiot.mclaren.senna.sdk.dto.ThingConfigDTO;
import aiot.mclaren.senna.sdk.request.ThingConfigDetailQuery;
import aiot.mclaren.senna.sdk.request.ThingConfigQuery;
import aiot.mclaren.senna.sdk.response.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lsj
 * @date 2021/3/9 11:28
 */
@Api(tags = "物配置相关")
@FeignClient(name = "aiot-mclaren-senna-service", contextId = "thing-config")
@RequestMapping("thing-configs")
public interface ThingConfigApi {
    @ApiOperation("创建物配置")
    @PostMapping
    DataResponse<ThingConfigDTO> create(@Validated @RequestBody ThingConfigBody body);

    @ApiOperation("物配置列表")
    @GetMapping
    DataResponse<PageList<ThingConfigDTO>> listPage(@Validated ThingConfigQuery query);

    @ApiOperation("物配置详情")
    @GetMapping("detail")
    DataResponse<ThingConfigDTO> getDetail(@Validated ThingConfigDetailQuery query);

}
