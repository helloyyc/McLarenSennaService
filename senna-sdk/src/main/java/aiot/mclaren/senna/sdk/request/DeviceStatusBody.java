package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lsj
 * @date 2021/3/8 11:43
 */
@ApiModel("设备状态更新参数")
@Data
public class DeviceStatusBody {

    @NotBlank(message = "产品KEY不能为空")
    @ApiModelProperty("产品KEY")
    private String productKey;

    @NotBlank(message = "设备名称不能为空")
    @ApiModelProperty("设备名称")
    private String deviceName;

    @ApiModelProperty("客户端IP")
    private String ipAddress;

    @ApiModelProperty("设备状态")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty("最后更新时间")
    @NotNull(message = "最后更新时间不能为空")
    private Long lastTime;
}
