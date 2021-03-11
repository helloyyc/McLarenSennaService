package aiot.mclaren.senna.host.controller;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.service.IDeviceMessageService;
import aiot.mclaren.senna.sdk.api.DeviceMessageApi;
import aiot.mclaren.senna.sdk.request.InvokeServiceBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsj
 * @date 2021/3/8 19:33
 */
@RestController
public class DeviceMessageController implements DeviceMessageApi {

    @Autowired
    private IDeviceMessageService deviceMessageService;

    @Override
    public DataResponse<Boolean> invokeService(InvokeServiceBody body) {
        return DataResponse.success(deviceMessageService.invokeService(body));
    }
}
