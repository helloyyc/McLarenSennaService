package aiot.mclaren.senna.host.service.impl;
import java.time.LocalDateTime;

import aiot.mclaren.senna.model.constant.SysTopicConst;
import aiot.mclaren.senna.model.entity.DeviceAcl;
import aiot.mclaren.senna.host.mapper.DeviceAclMapper;
import aiot.mclaren.senna.host.service.IDeviceAclService;
import aiot.mclaren.senna.model.enums.DefaultAclEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean initDeviceDefaultAcl(String productKey, String deviceName, String username) {
        List<DeviceAcl> deviceAcls = new ArrayList<>();
        for (DefaultAclEnum aclEnum : DefaultAclEnum.values()) {
            DeviceAcl deviceAcl = new DeviceAcl();
            deviceAcl.setAllow(1);
            deviceAcl.setIpaddr("");
            deviceAcl.setUsername(username);
            deviceAcl.setClientid("");
            deviceAcl.setAccess(aclEnum.getAccess().getAccess());
            deviceAcl.setTopic(String.format(aclEnum.getTopicFormat(), productKey, deviceName));
            deviceAcls.add(deviceAcl);
        }
        return saveBatch(deviceAcls);
    }

    public void initDefaultSysAcl() {

    }


}
