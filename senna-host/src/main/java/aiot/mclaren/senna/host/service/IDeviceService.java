package aiot.mclaren.senna.host.service;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.model.entity.Device;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.DeviceBody;
import aiot.mclaren.senna.sdk.request.DeviceQuery;
import aiot.mclaren.senna.sdk.response.SimplePage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
public interface IDeviceService extends IService<Device> {

    DataResponse<DeviceDTO> create(DeviceBody body);

    DataResponse<SimplePage<DeviceDTO>> selectPage(DeviceQuery query);

    Device getByDeviceNameAndProductKey(String deviceName, String productKey);

}
