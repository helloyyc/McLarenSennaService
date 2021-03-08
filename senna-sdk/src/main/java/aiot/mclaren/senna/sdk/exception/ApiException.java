package aiot.mclaren.senna.sdk.exception;

import aiot.mclaren.commons.response.DefaultCode;
import aiot.mclaren.commons.response.ResultCode;
import lombok.Getter;

import java.util.Map;

/**
 * @author lsj
 * @date 2021/2/7 12:22
 */
@Getter
public class ApiException extends RuntimeException implements ResultCode {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private Map<String, Object> errors;

    public ApiException(ResultCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public ApiException(ResultCode code, String msg) {
        this.code = code.getCode();
        this.msg = msg;
    }

    public ApiException(ResultCode code, Map<String, Object> errors) {
        this(code);
        this.errors = errors;
    }

    public ApiException(Throwable e) {
        super(e);
        this.code = DefaultCode.UNKNOWN_ERROR.getCode();
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
