package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lsj
 * @date 2021/3/8 20:09
 */
@Data
@ApiModel("服务调用参数")
public class InvokeServiceBody {
    @ApiModelProperty("产品KEY")
    @NotBlank(message = "产品KEY不能为空")
    private String productKey;

    @ApiModelProperty("设备名称")
    @NotBlank(message = "设备名称不能为空")
    private String deviceName;

    @ApiModelProperty("调用参数")
    private String args;

    @ApiModelProperty("服务标识符, 若果非默认模块则使用 例如调用模块为:testM, 服务为:testService 则参数值为: testM:testService")
    private String identifier;

}
