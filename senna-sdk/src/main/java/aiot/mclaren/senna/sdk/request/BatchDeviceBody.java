package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author lsj
 * @date 2021/3/8 17:03
 */
@Data
@ApiModel("设备批量创建参数")
public class BatchDeviceBody {
    @ApiModelProperty("产品KEY")
    @NotBlank(message = "产品KEY不能为空")
    private String productKey;
    private List<BatchDeviceItem> devices;

    @Data
    @ApiModel("设备信息参数")
    public static class BatchDeviceItem {
        @ApiModelProperty("设备名称")
        @NotBlank(message = "设备名称不能为空")
        private String deviceName;

        @ApiModelProperty("备注名称")
        private String nickName;

        @ApiModelProperty("设备描述")
        private String deviceDescription;
    }
}
