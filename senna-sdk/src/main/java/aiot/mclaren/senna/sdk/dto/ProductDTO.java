package aiot.mclaren.senna.sdk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lsj
 * @date 2021/2/6 17:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "产品")
public class ProductDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("节点类型")
    private Long nodeType;

    @ApiModelProperty("所属品类")
    private Long categoryId;

    @ApiModelProperty("数据格式 1: json")
    private Integer dataFormat;

    @ApiModelProperty("认证方式 1: 设备秘钥")
    private Long authType;

    @ApiModelProperty("设备秘钥认证方式 需要选择安全模式 1: 一机一密 2: 一型一密")
    private Integer secureMode;

    @ApiModelProperty("产品状态")
    private Integer productStatus;

    @ApiModelProperty("网络类型")
    private Long netType;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("产品描述")
    private String productDescription;

    @ApiModelProperty("产品Key")
    private String productKey;

    @ApiModelProperty("产品secret")
    private String productSecret;
}
