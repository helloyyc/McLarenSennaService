package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lsj
 * @date 2021/3/10 17:51
 */
@ApiModel("物配置详情查询参数")
@Data
public class ThingConfigDetailQuery {
    @ApiModelProperty("产品Key")
    @NotBlank(message = "产品KEY不能为空")
    private String productKey;
    @ApiModelProperty("设备名称")
    private String deviceName;
    @ApiModelProperty("配置范围")
    private String scope;
    @ApiModelProperty("配置状态 默认为: 生效 1")
    private Integer status = 1;
}
