package aiot.mclaren.senna.host.exception;

import aiot.mclaren.commons.response.DefaultCode;
import aiot.mclaren.commons.response.ResultCode;
import lombok.Getter;

/**
 * @author lsj
 * @date 2021/2/7 12:22
 */
@Getter
public class ApiException extends RuntimeException implements ResultCode {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;

    public ApiException(ResultCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public ApiException(ResultCode code, String msg) {
        this.code = code.getCode();
        this.msg = msg;
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
