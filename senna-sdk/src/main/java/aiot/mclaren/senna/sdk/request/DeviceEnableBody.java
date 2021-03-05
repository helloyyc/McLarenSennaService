package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lsj
 * @date 2021/3/5 14:53
 */
@Data
@ApiModel
public class DeviceEnableBody {
    @ApiModelProperty("产品KEY")
    @NotBlank(message = "产品KEY不能为空")
    private String productKey;

    @ApiModelProperty("设备名称")
    @NotBlank(message = "设备名称不能为空")
    private String deviceName;
}
