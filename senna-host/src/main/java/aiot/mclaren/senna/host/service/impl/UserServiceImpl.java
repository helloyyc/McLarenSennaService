package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.model.entity.User;
import aiot.mclaren.senna.host.mapper.UserMapper;
import aiot.mclaren.senna.host.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
