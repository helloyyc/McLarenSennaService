package aiot.mclaren.senna.model.enums;

import lombok.Getter;

/**
 * @author lsj
 * @date 2021/3/3 21:34
 */
@Getter
public enum DeviceStatusEnum {
    /**
     * 未激活
     */
    UNACTIVE(2, "UNACTIVE"),

    /**
     * 在线
     */
    ONLINE(1, "ONLINE"),

    /**
     * 离线
     */
    OFFLINE(0, "OFFLINE"),

    ;

    private final int code;
    private final String name;

    DeviceStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }


    public static DeviceStatusEnum valueOf(int code) {
        DeviceStatusEnum[] values = values();
        for (DeviceStatusEnum value : values) {
            if (code == value.getCode()) {
                return value;
            }
        }
        throw new RuntimeException("can't value of code: " + code);
    }
}
