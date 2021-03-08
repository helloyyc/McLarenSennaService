package aiot.mclaren.senna.host.service;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.model.entity.DeviceAcl;
import aiot.mclaren.senna.sdk.dto.DeviceAclDTO;
import aiot.mclaren.senna.sdk.request.DeviceAclBody;
import aiot.mclaren.senna.sdk.request.DeviceDefaultAclBody;
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
public interface IDeviceAclService extends IService<DeviceAcl> {

    boolean initNewDeviceDefaultAcl(DeviceDefaultAclBody body);

    boolean initMultiNewDeviceDefaultAcl(List<DeviceDefaultAclBody> bodyList);

    boolean initSysDefaultAcl();

    DataResponse<DeviceAclDTO> createOrUpdate(DeviceAclBody body);


}
