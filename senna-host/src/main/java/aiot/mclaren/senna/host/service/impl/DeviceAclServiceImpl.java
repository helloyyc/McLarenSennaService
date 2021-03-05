package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.model.entity.DeviceAcl;
import aiot.mclaren.senna.host.mapper.DeviceAclMapper;
import aiot.mclaren.senna.host.service.IDeviceAclService;
import aiot.mclaren.senna.model.enums.DeviceDefaultAclEnum;
import aiot.mclaren.senna.model.enums.SystemDefaultAclEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@Service
public class DeviceAclServiceImpl extends ServiceImpl<DeviceAclMapper, DeviceAcl> implements IDeviceAclService {

    @Override
    public boolean initNewDeviceDefaultAcl(String productKey, String deviceName, String username) {
        List<DeviceAcl> deviceAcls = new ArrayList<>();
        for (DeviceDefaultAclEnum aclEnum : DeviceDefaultAclEnum.values()) {
            DeviceAcl deviceAcl = new DeviceAcl();
            deviceAcl.setAllow(1);
            deviceAcl.setIpaddr(null);
            deviceAcl.setUsername(username);
            deviceAcl.setClientid(null);
            deviceAcl.setAccess(aclEnum.getAccess().getAccess());
            deviceAcl.setTopic(String.format(aclEnum.getTopicFormat(), productKey, deviceName));
            deviceAcls.add(deviceAcl);
        }
        return saveBatch(deviceAcls);
    }

    @Override
    public boolean initSysDefaultAcl() {
        List<DeviceAcl> sysAcls = new ArrayList<>();
        for (SystemDefaultAclEnum aclEnum : SystemDefaultAclEnum.values()) {

            DeviceAcl deviceAcl = new DeviceAcl();
            deviceAcl.setAllow(aclEnum.getAllow());
            deviceAcl.setIpaddr(aclEnum.getIpaddr());
            deviceAcl.setUsername(aclEnum.getUsername());
            deviceAcl.setClientid(aclEnum.getClientId());
            deviceAcl.setAccess(aclEnum.getAccess().getAccess());
            deviceAcl.setTopic(aclEnum.getTopic());
            sysAcls.add(deviceAcl);
        }
        return saveBatch(sysAcls);
    }

}
