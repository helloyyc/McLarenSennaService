package aiot.mclaren.senna.host.service;

import aiot.mclaren.senna.model.entity.Device;
import aiot.mclaren.senna.model.enums.DeviceEnableEnum;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.*;
import aiot.mclaren.senna.sdk.response.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
public interface IDeviceService extends IService<Device> {

    DeviceDTO create(DeviceBody body);

    List<DeviceDTO> batchCreate(BatchDeviceBody body);

    PageList<DeviceDTO> queryPage(DeviceQuery query);

    Device getByDeviceNameAndProductKey(String deviceName, String productKey);

    boolean updateEnableStatus(DeviceEnableBody body, DeviceEnableEnum enable);

    boolean updateDeviceStatus(DeviceStatusBody body);

}
