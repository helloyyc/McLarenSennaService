package aiot.mclaren.senna.model.enums;

import lombok.Getter;

/**
 * @author lsj
 * @date 2021/3/4 21:51
 */
@Getter
public enum TopicAccessEnum {
    /**
     * 订阅
     */
    SUBSCRIBE(1),

    /**
     * 发布
     */
    PUBLISH(2),

    /**
     * 发布订阅都可以
     */
    PUB_SUB(3),

    ;

    private final int access;

    TopicAccessEnum(int access) {
        this.access = access;
    }

}
