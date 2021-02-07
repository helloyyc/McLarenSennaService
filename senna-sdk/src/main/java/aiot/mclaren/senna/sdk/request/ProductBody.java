package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lsj
 * @date 2021/2/6 17:21
 */
@Data
@ApiModel("产品创建参数")
public class ProductBody {
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

    @ApiModelProperty("网络类型")
    private Long netType;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("产品描述")
    private String productDescription;
}
