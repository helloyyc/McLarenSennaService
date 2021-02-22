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
     * 品类相关错误码
     */
    CATEGORY_NOT_FOUND(10200, "指定品类不存在"),
    DATABASE_OPERATION_EXCEPTION(20100, "数据库操作异常")
    ;

    private final int code;

    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
