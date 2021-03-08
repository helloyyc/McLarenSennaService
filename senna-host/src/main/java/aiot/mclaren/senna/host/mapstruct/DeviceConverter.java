package aiot.mclaren.senna.host.mapstruct;

import aiot.mclaren.senna.model.entity.Device;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.BatchDeviceBody;
import aiot.mclaren.senna.sdk.request.DeviceBody;
import aiot.mclaren.senna.sdk.response.PageList;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author lsj
 * @date 2021/2/7 17:02
 */
@Mapper
public interface DeviceConverter {
    DeviceConverter INSTANCE = Mappers.getMapper(DeviceConverter.class);

    Device toDevice(DeviceBody body);

    DeviceDTO toDeviceDTO(Device device);

    List<DeviceDTO> toDeviceDTOs(List<Device> devices);

    PageList<DeviceDTO> toDeviceDTOPages(IPage<Device> page);

    Device toDevice(BatchDeviceBody.BatchDeviceItem item);
}
