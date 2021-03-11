package aiot.mclaren.senna.host.service;

import aiot.mclaren.senna.sdk.request.InvokeServiceBody;

/**
 * @author lsj
 * @date 2021/3/8 20:31
 */

public interface IDeviceMessageService {
    boolean invokeService(InvokeServiceBody body);
}
