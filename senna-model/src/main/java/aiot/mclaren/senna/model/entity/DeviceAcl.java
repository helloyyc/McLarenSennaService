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
public class DeviceAcl extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 0: deny, 1: allow
     */
    private Integer allow;

    /**
     * IpAddress
     */
    private String ipaddr;

    /**
     * Username
     */
    private String username;

    /**
     * ClientId
     */
    private String clientid;

    /**
     * 1: subscribe, 2: publish, 3: pubsub
     */
    private Integer access;

    /**
     * Topic Filter
     */
    private String topic;


}
