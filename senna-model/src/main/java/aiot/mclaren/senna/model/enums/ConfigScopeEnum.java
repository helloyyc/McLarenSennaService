package aiot.mclaren.senna.model.enums;

import lombok.Getter;

/**
 * @author lsj
 * @date 2021/3/10 12:07
 */
@Getter
public enum ConfigScopeEnum {
    /**
     * 产品
     */
    PRODUCT("product"),
    /**
     * 设备
     */
    DEVICE("device")
    ;
    private final String value;

    ConfigScopeEnum(String value) {
        this.value = value;
    }
}
