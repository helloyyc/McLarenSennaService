package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lsj
 * @date 2021/3/5 10:49
 */
@Data
@ApiModel("设备主题ACL创建/更新参数")
public class DeviceAclBody {

    @ApiModelProperty("ACL ID")
    private Long id;

    @ApiModelProperty("1: 允许, 0: 拒绝, 为空时默认为允许")
    private Integer allow;

    @ApiModelProperty("IPV4 地址")
    private String ipaddr;

    @ApiModelProperty("连接客户端的用户名")
    private String username;

    @ApiModelProperty("连接客户端的ClientId")
    private String clientid;

    @ApiModelProperty("1: 订阅, 2: 发布, 3: 发布和订阅")
    @NotNull(message = "允许的操作不能为空")
    @Range(min = 1, max = 3, message = "允许的操作仅支持 1: 订阅, 2: 发布, 3: 发布和订阅")
    private Integer access;

    @ApiModelProperty("控制的主题")
    @NotBlank(message = "控制的主题不能为空")
    private String topic;
}
