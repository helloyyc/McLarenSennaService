package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.model.entity.Device;
import aiot.mclaren.senna.host.mapper.DeviceMapper;
import aiot.mclaren.senna.host.service.IDeviceService;
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
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

}
