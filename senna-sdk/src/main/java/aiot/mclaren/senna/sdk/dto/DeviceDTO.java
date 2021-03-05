package aiot.mclaren.senna.sdk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author lsj
 * @date 2021/3/3 15:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("设备")
public class DeviceDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("设备ID")
    private String iotId;

    @ApiModelProperty("产品KEY")
    private String productKey;

    @ApiModelProperty("设备名称")
    private String deviceName;

    @ApiModelProperty("设备秘钥")
    private String deviceSecret;

    @ApiModelProperty("备注名称")
    private String nickName;

    @ApiModelProperty("设备状态 0: 离线 1:  在线 2: 未激活")
    private Integer deviceStatus;

    @ApiModelProperty("启用状态 0: 未启用, 1: 已启用")
    private Integer enable;

    @ApiModelProperty("设备描述")
    private String deviceDescription;

    @ApiModelProperty("激活时间")
    private LocalDateTime activeDt;

    @ApiModelProperty("最后上线时间")
    private LocalDateTime onlineDt;
}
