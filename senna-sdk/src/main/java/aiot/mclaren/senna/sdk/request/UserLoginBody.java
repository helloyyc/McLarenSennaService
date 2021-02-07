package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lsj
 * @date 2021/2/6 18:26
 */
@Data
@ApiModel("用户登录参数")
public class UserLoginBody {

    @ApiModelProperty("用户名、手机号或者邮箱")
    @NotBlank(message = "账号不能为空")
    private String account;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
