package aiot.mclaren.senna.model.enums;

import lombok.Getter;

/**
 * @author lsj
 * @date 2021/3/3 21:34
 */
@Getter
public enum DeviceStatusEnum {
    /**
     * 已禁用
     */
    DISABLE(0, "DISABLE"),

    /**
     * 未激活
     */
    UNACTIVE(1, "UNACTIVE"),

    /**
     * 已经激活
     */
    ACTIVE(2, "ACTIVE")

    ;

    private final int id;
    private final String name;

    DeviceStatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
