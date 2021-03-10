package aiot.mclaren.senna.model.entity;

import aiot.mclaren.senna.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-03-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ThingConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 配置ID
     */
    private String configId;

    /**
     * 配置大小
     */
    private Long configSize;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 产品KEY
     */
    private String productKey;

    /**
     * 配置状态 1表示有效 0表示失效
     */
    private Integer status;

    /**
     * 配置范围
     */
    private String scope;

    /**
     * 配置格式
     */
    private String configFormat;

    /**
     * 签名方法
     */
    private String signMethod;

    /**
     * 签名
     */
    private String sign;

    /**
     * oss的路径
     */
    private String ossPath;

    /**
     * oss的地址
     */
    private String ossUrl;

    /**
     * oss的版本ID
     */
    private String ossVersionId;


}
