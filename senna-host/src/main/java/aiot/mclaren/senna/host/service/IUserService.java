package aiot.mclaren.senna.host.service;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.model.entity.User;
import aiot.mclaren.senna.sdk.dto.UserDTO;
import aiot.mclaren.senna.sdk.request.UserLoginBody;
import aiot.mclaren.senna.sdk.request.UserRegisterBody;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
public interface IUserService extends IService<User> {

    DataResponse<UserDTO> login(UserLoginBody body);

    DataResponse<Long> register(UserRegisterBody body);

}
