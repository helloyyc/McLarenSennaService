package aiot.mclaren.senna.model.enums;

import lombok.Getter;

/**
 * @author lsj
 * @date 2021/3/5 9:47
 */
@Getter
public enum SystemDefaultAclEnum {
    /**
     * 禁止所有用户订阅系统主题
     */
    SYS_SYS_TOPIC(0, null, "$all", null, TopicAccessEnum.SUBSCRIBE, "$SYS/#"),

    /**
     * 禁止所有用户使用 # 号通配符订阅所有主题
     */
    SYS_WILDCARD_ALL(0, null, "$all", null, TopicAccessEnum.SUBSCRIBE, "#"),

    /**
     * 禁止所有用户使用 /# 订阅 / 下所有主题
     */
    SYS_SLASH_WILDCARD_ALL(0, null, "$all", null, TopicAccessEnum.SUBSCRIBE, "/#"),

    ;

    SystemDefaultAclEnum(int allow, String ipaddr, String username, String clientId, TopicAccessEnum access, String topic) {
        this.allow = allow;
        this.ipaddr = ipaddr;
        this.username = username;
        this.clientId = clientId;
        this.access = access;
        this.topic = topic;
    }

    private final int allow;
    private final String ipaddr;
    private final String username;
    private final String clientId;
    private final TopicAccessEnum access;
    private final String topic;


}
