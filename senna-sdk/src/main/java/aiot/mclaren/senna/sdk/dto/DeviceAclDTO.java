package aiot.mclaren.senna.sdk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lsj
 * @date 2021/3/5 11:05
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("设备ACL")
@Data
public class DeviceAclDTO extends BaseDTO{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("1: 允许, 0: 拒绝")
    private Integer allow;

    @ApiModelProperty("IPV4 地址")
    private String ipaddr;

    @ApiModelProperty("连接客户端的用户名")
    private String username;

    @ApiModelProperty("连接客户端的ClientId")
    private String clientid;

    @ApiModelProperty("1: 订阅, 2: 发布, 3: 发布和订阅")
    private Integer access;

    @ApiModelProperty("作用的主题")
    private String topic;
}
