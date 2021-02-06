package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.model.entity.DeviceAcl;
import aiot.mclaren.senna.host.mapper.DeviceAclMapper;
import aiot.mclaren.senna.host.service.IDeviceAclService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@Service
public class DeviceAclServiceImpl extends ServiceImpl<DeviceAclMapper, DeviceAcl> implements IDeviceAclService {

}
