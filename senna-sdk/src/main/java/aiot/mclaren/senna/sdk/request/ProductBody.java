package aiot.mclaren.senna.sdk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @author lsj
 * @date 2021/2/6 17:21
 */
@Data
@ApiModel("产品创建参数")
public class ProductBody {
    @ApiModelProperty("产品名称")
    @NotBlank(message = "产品名称不能为空")
    private String productName;

//    @ApiModelProperty("节点类型 1:直连类型")
//    private Long nodeType;

    @ApiModelProperty("所属品类")
    private Long categoryId;

    @ApiModelProperty("数据格式 1: json 2: 透传类型")
    @Range(min = 1, max = 2, message = "数据格式只能为json格式或透传类型")
    private Integer dataFormat;

//    @ApiModelProperty("认证方式 1: 设备秘钥")
//    private Long authType;

    @ApiModelProperty("设备秘钥认证方式 需要选择安全模式 1: 一机一密 2: 一型一密")
    @Range(min = 1, max = 2, message = "安全模式只能为一机一密或一型一密")
    private Integer secureMode;

    @ApiModelProperty("网络类型 1: WIFI 2: 蜂窝(2G/3G/4G/5G) 3: 以太网 4: 其他")
    @Range(min = 1, max = 2, message = "网络类型只能为WIFI、蜂窝(2G/3G/4G/5G)、以太网、其他")
    private Long netType;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("产品描述")
    @Length(max = 100, message = "产品描述最多100个字符")
    private String productDescription;
}
