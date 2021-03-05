package aiot.mclaren.senna.host.service;

import aiot.mclaren.senna.model.entity.DeviceAcl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
public interface IDeviceAclService extends IService<DeviceAcl> {

    boolean initNewDeviceDefaultAcl(String productKey, String deviceName, String username);

    boolean initSysDefaultAcl();

}
