package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lsj
 * @date 2021/2/6 18:28
 */
@Data
@ApiModel("用户注册")
public class UserRegisterBody {

    @ApiModelProperty("用户名")
    @NotBlank(message = "账号不能为空")
    private String username;

    @ApiModelProperty("密码明文")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty("再次密码")
    @NotBlank(message = "请再次输入密码")
    private String repeatPassword;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱号")
    private String email;

    @ApiModelProperty("头像地址")
    private String avator;
}
