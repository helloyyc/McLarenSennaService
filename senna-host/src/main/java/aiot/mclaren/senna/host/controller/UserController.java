package aiot.mclaren.senna.host.controller;


import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.service.IUserService;
import aiot.mclaren.senna.sdk.api.UserApi;
import aiot.mclaren.senna.sdk.dto.UserDTO;
import aiot.mclaren.senna.sdk.request.UserLoginBody;
import aiot.mclaren.senna.sdk.request.UserRegisterBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@RestController
public class UserController implements UserApi {

    @Autowired
    private IUserService userService;

    @Override
    public DataResponse<UserDTO> login(UserLoginBody body) {
        return userService.login(body);
    }

    @Override
    public DataResponse<Long> register(UserRegisterBody body) {
        return userService.register(body);
    }
}

