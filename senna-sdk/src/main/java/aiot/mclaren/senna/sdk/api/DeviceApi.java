package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.DeviceBody;
import aiot.mclaren.senna.sdk.request.DeviceQuery;
import aiot.mclaren.senna.sdk.response.SimplePage;
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
 * @date 2021/2/6 16:45
 */
@Api(tags = "设备")
@FeignClient(name = "${spring.application.name}", contextId = "device")
@RequestMapping("devices")
public interface DeviceApi {

    @ApiOperation("创建产品")
    @PostMapping
    DataResponse<DeviceDTO> create(@Validated @RequestBody DeviceBody body);

    @ApiOperation("设备列表")
    @GetMapping
    DataResponse<SimplePage<DeviceDTO>> selectPage(@Validated DeviceQuery query);
}
