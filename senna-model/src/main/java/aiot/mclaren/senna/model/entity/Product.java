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
 * @since 2021-02-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 节点类型
     */
    private Long nodeType;

    /**
     * 所属品类ID
     */
    private Long categoryId;

    /**
     * 数据格式 1 json
     */
    private Integer dataFormat;

    /**
     * 认证方式 1 设备秘钥
     */
    private Long authType;

    /**
     * 设备秘钥认证方式 需要选择安全模式 1: 一机一密 2: 一型一密
     */
    private Integer secureMode;

    /**
     * 产品状态
     */
    private Integer productStatus;

    /**
     * 网络类型
     */
    private Long netType;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 产品描述
     */
    private String productDescription;

    /**
     * 产品KEY
     */
    private String productKey;

    /**
     * 产品secret
     */
    private String productSecret;


}
