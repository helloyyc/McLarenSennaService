package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author lsj
 * @date 2021/3/10 11:30
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("物配置查询参数")
@Data
public class ThingConfigQuery extends PageQuery {
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
