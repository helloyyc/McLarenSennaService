package aiot.mclaren.senna.model.entity;

import aiot.mclaren.senna.model.entity.BaseEntity;
import java.time.LocalDateTime;
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
public class Device extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String nickName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 设备名
     */
    private String deviceName;

    /**
     * 是否超级用户 1是 ,0 否
     */
    private Boolean isSuperuser;

    /**
     * 设备secret
     */
    private String deviceSecret;

    /**
     * 设备描述
     */
    private String deviceDescrption;

    /**
     * 设备状态
     */
    private Long deviceStatus;

    /**
     * 激活时间
     */
    private LocalDateTime activeDt;

    /**
     * 最后上线时间
     */
    private LocalDateTime onlineDt;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 启用状态
     */
    private Integer enable;


}
