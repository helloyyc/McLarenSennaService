package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.DeviceBody;
import aiot.mclaren.senna.sdk.request.DeviceEnableBody;
import aiot.mclaren.senna.sdk.request.DeviceQuery;
import aiot.mclaren.senna.sdk.request.DeviceStatusBody;
import aiot.mclaren.senna.sdk.response.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author lsj
 * @date 2021/2/6 16:45
 */
@Api(tags = "设备相关")
@FeignClient(name = "aiot-mclaren-senna-service", contextId = "device")
@RequestMapping("devices")
public interface DeviceApi {

    @ApiOperation("创建产品")
    @PostMapping
    DataResponse<DeviceDTO> create(@Validated @RequestBody DeviceBody body);

    @ApiOperation("设备列表")
    @GetMapping
    DataResponse<PageList<DeviceDTO>> listPage(@Validated DeviceQuery query);

    @ApiOperation("设备详情")
    @GetMapping("{id}")
    DataResponse<DeviceDTO> getById(@PathVariable Long id);

    @ApiOperation("快速签名")
    @GetMapping("quick_sign")
    DataResponse<String> quickSign(@RequestParam String deviceName, @RequestParam String secret);

    @ApiOperation("启用设备")
    @PutMapping("enable_status/enable")
    DataResponse<Boolean> enableDevice(@Validated @RequestBody DeviceEnableBody body);

    @ApiOperation("禁用设备")
    @PutMapping("enable_status/disable")
    DataResponse<Boolean> disableDevice(@Validated @RequestBody DeviceEnableBody body);

    @ApiOperation("删除设备")
    @DeleteMapping("{id}")
    DataResponse<Boolean> deleteById(@PathVariable Long id);

    @ApiOperation("更新设备状态")
    @PostMapping("status")
    DataResponse<Boolean> updateDeviceStatus(@Validated @RequestBody DeviceStatusBody body);
}
