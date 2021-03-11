package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.sdk.request.InvokeServiceBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lsj
 * @date 2021/3/8 19:36
 */
@Api(tags = "设备消息相关")
@FeignClient(name = "aiot-mclaren-senna-service", contextId = "device-messages")
@RequestMapping("device-messages")
public interface DeviceMessageApi {

    @ApiOperation("设备服务调用")
    @PostMapping("invoke-service")
    DataResponse<Boolean> invokeService(@Validated @RequestBody InvokeServiceBody body);

}
