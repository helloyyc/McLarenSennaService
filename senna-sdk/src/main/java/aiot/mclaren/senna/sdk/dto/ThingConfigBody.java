package aiot.mclaren.senna.sdk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lsj
 * @date 2021/3/9 11:31
 */
@ApiModel("物配置请求参数")
@Data
public class ThingConfigBody {
    @ApiModelProperty("产品KEY")
    @NotBlank(message = "产品KEY不能为空")
    private String productKey;

    @ApiModelProperty("设备名称")
    private String deviceName;

    @ApiModelProperty("配置内容")
    private String configContent = "{}";

}
