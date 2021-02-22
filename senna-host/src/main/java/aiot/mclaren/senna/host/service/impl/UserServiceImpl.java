package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.commons.response.DefaultCode;
import aiot.mclaren.senna.host.common.SecurityUtils;
import aiot.mclaren.senna.host.exception.ApiException;
import aiot.mclaren.senna.host.mapstruct.UserConverter;
import aiot.mclaren.senna.sdk.response.ErrorCode;
import aiot.mclaren.senna.model.entity.User;
import aiot.mclaren.senna.host.mapper.UserMapper;
import aiot.mclaren.senna.host.service.IUserService;
import aiot.mclaren.senna.sdk.dto.UserDTO;
import aiot.mclaren.senna.sdk.request.UserLoginBody;
import aiot.mclaren.senna.sdk.request.UserRegisterBody;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

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


    @Override
    public DataResponse<UserDTO> login(UserLoginBody body) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.and(i -> {
            i.eq("username", body.getAccount()).or().eq("phone", body.getAccount()).or().eq("email", body.getAccount());
        });

        User currentUser =
            Optional.ofNullable(this.getOne(wrapper)).orElseThrow(() -> new ApiException(ErrorCode.ACCOUNT_NOT_EXISTS));

        String passwordHash = SecurityUtils.getPasswordHash(body.getPassword(), currentUser.getSalt());
        if (!passwordHash.equals(currentUser.getPassword())) {
            throw new ApiException(ErrorCode.ACCOUNT_OR_PASSWORD_ERROR);
        }
        return DataResponse.success(UserConverter.INSTANCE.toUserDTO(currentUser));
    }

    @Override
    public DataResponse<Long> register(UserRegisterBody body) {
        User user = UserConverter.INSTANCE.toUserEntity(body);
        // 昵称不存在使用用户名作为昵称
        if (StringUtils.isEmpty(user.getNickName())) {
            user.setNickName(user.getUsername());
        }
        user.setSalt(SecurityUtils.getSalt());
        user.setPassword(SecureUtil.sha256(body.getPassword() + user.getSalt()));
        user.setEnable(true);
        return this.save(user) ? DataResponse.success(user.getId()) : new DataResponse<>(DefaultCode.UNKNOWN_ERROR);
    }
}
