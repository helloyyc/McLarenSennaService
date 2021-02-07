package aiot.mclaren.senna.sdk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lsj
 * @date 2021/2/6 18:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "用户")
public class UserDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像地址")
    private String avator;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱地址")
    private String email;
}
