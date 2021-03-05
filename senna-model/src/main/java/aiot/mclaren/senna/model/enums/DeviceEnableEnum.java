package aiot.mclaren.senna.model.enums;

import lombok.Getter;

/**
 * @author lsj
 * @date 2021/3/5 14:12
 */
@Getter
public enum DeviceEnableEnum {
    /**
     * 已禁用
     */
    DISABLE(0, "DISABLE"),

    /**
     * 已启用
     */
    ENABLE(1, "ENABLE"),
    ;
    private final int code;
    private final String name;

    DeviceEnableEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
