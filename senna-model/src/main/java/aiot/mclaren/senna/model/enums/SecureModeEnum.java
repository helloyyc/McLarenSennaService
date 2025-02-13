package aiot.mclaren.senna.model.enums;

import lombok.Getter;

/**
 * @author lsj
 * @date 2021/1/29 16:34
 */
@Getter
public enum SecureModeEnum {

    /**
     * 一机一密
     */
    ONE_MACHINE_ONE_SECRET(1, "ONE_MACHINE_ONE_SECRET"),

    /**
     * 一型一密
     */
    ONE_PRODUCT_ONE_SECRET(2, "ONE_PRODUCT_ONE_SECRET")

    ;
    private final int id;
    private final String modeName;

    SecureModeEnum(int id, String modeName) {
        this.id = id;
        this.modeName = modeName;
    }
}
