package aiot.mclaren.senna.host.service;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.model.entity.Device;
import aiot.mclaren.senna.model.enums.DeviceEnableEnum;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.DeviceBody;
import aiot.mclaren.senna.sdk.request.DeviceEnableBody;
import aiot.mclaren.senna.sdk.request.DeviceQuery;
import aiot.mclaren.senna.sdk.response.PageList;
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

    DataResponse<PageList<DeviceDTO>> queryPage(DeviceQuery query);

    Device getByDeviceNameAndProductKey(String deviceName, String productKey);

    DataResponse<Boolean> updateEnableStatus(DeviceEnableBody body, DeviceEnableEnum enable);

    DataResponse<Boolean> deleteById(Long id);

}
