package aiot.mclaren.senna.sdk.response;

import aiot.mclaren.commons.response.ResultCode;
import lombok.Getter;

/**
 * @author lsj
 * @date 2021/2/7 14:07
 */
@Getter
public enum ErrorCode implements ResultCode {
    /**
     * 参数不合法
     */
    ARGUMENT_ILLEGAL(10001, "参数不合法"),
    /**
     * 用户相关错误码
     */
    ACCOUNT_NOT_EXISTS(10100, "用户不存在"),
    ACCOUNT_OR_PASSWORD_ERROR(10101, "账户或者密码错误"),

    /**
     * 产品相关错误码
     */
    PRODUCT_NOT_FOUND(10200, "产品不存在"),
    PRODUCT_NAME_EXISTS(10201, "产品名称已存在"),
    PRODUCT_SECURE_MODE_NOT_SUPPORT(10202, "产品秘钥认证方式不支持"),


    /**
     * 设备相关错误码
     */
    DEVICE_NOT_FOUND(10400, "设备不存在"),
    DEVICE_NAME_EXISTS(10401, "设备名称已存在"),

    /**
     * 品类相关错误码
     */
    CATEGORY_NOT_FOUND(10600, "指定品类不存在"),
    DATABASE_OPERATION_EXCEPTION(20100, "数据库操作异常")
    ;

    private final int code;

    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
