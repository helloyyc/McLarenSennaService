package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.sdk.dto.UserDTO;
import aiot.mclaren.senna.sdk.request.UserLoginBody;
import aiot.mclaren.senna.sdk.request.UserRegisterBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lsj
 * @date 2021/2/6 17:29
 */
@Api(tags = "用户管理")
@RequestMapping("user")
@FeignClient(name = "${spring.application.name}", contextId = "user")
public interface UserApi {


    @ApiOperation("用户登录")
    @PostMapping("login")
    DataResponse<UserDTO> login(@Validated @RequestBody UserLoginBody body);

    @ApiOperation("用户注册")
    @PostMapping("register")
    DataResponse<Long> register(@Validated @RequestBody UserRegisterBody body);

}
