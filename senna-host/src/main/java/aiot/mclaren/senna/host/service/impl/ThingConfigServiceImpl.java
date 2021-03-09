package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.model.entity.ThingConfig;
import aiot.mclaren.senna.host.mapper.ThingConfigMapper;
import aiot.mclaren.senna.host.service.IThingConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-03-09
 */
@Service
public class ThingConfigServiceImpl extends ServiceImpl<ThingConfigMapper, ThingConfig> implements IThingConfigService {

}
