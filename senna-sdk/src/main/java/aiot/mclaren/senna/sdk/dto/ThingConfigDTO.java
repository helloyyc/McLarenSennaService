package aiot.mclaren.senna.sdk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lsj
 * @date 2021/3/9 11:30
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("物配置")
@Data
public class ThingConfigDTO extends BaseDTO {

    @ApiModelProperty("配置ID")
    private String configId;

    @ApiModelProperty("配置大小")
    private Long configSize;

    @ApiModelProperty("设备名称")
    private String deviceName;

    @ApiModelProperty("产品KEY")
    private String productKey;


    @ApiModelProperty("配置状态 1表示有效 0表示失效")
    private Integer status;

    /**
     * 配置范围
     */
    @ApiModelProperty("配置范围 device/product")
    private String scope;

    /**
     * 配置格式
     */
    @ApiModelProperty("配置格式")
    private String configFormat;

    /**
     * 签名方法
     */
    @ApiModelProperty("签名方法")
    private String signMethod;

    /**
     * 签名
     */
    @ApiModelProperty("签名")
    private String sign;

    /**
     * oss的路径
     */
    @ApiModelProperty("oss的路径")
    private String ossPath;

    /**
     * oss的地址
     */
    @ApiModelProperty("oss的地址")
    private String ossUrl;

    /**
     * oss的版本ID
     */
    @ApiModelProperty("oss的版本ID")
    private String ossVersionId;

}
