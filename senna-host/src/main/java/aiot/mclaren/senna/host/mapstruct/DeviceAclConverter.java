package aiot.mclaren.senna.host.mapstruct;

import aiot.mclaren.senna.model.entity.DeviceAcl;
import aiot.mclaren.senna.sdk.dto.DeviceAclDTO;
import aiot.mclaren.senna.sdk.request.DeviceAclBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author lsj
 * @date 2021/3/5 11:21
 */

@Mapper
public interface DeviceAclConverter {
    DeviceAclConverter INSTANCE = Mappers.getMapper(DeviceAclConverter.class);

    DeviceAcl toDeviceAcl(DeviceAclBody body);

    DeviceAclDTO toDeviceAclDTO(DeviceAcl deviceAcl);

}
