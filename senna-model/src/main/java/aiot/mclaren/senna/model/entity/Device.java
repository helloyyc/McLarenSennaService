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

    /**
     * 设备ID全局唯一
     */
    private String iotId;

    /**
     * 设备别名
     */
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
     * 设备名,产品唯一
     */
    private String deviceName;

    /**
     * 是否超级用户 1: 是, 0: 否
     */
    private Boolean isSuperuser;

    /**
     * 设备secret
     */
    private String deviceSecret;

    /**
     * 设备描述
     */
    private String deviceDescription;

    /**
     * 设备状态 0: 离线 1:  在线 2: 未激活
     */
    private Integer deviceStatus;

    /**
     * 激活时间
     */
    private LocalDateTime activeDt;

    /**
     * 最后上线时间
     */
    private LocalDateTime onlineDt;

    /**
     * 产品KEY
     */
    private String productKey;

    /**
     * 启用状态 0: 未启用, 1: 已启用
     */
    private Integer enable;

    /**
     * IP 地址
     */
    private String ipAddress;

    /**
     * 固件版本
     */
    private String firmwareVersion;


}
