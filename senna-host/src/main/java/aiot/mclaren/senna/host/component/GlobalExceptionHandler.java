package aiot.mclaren.senna.host.component;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.commons.response.ResultCode;
import aiot.mclaren.commons.util.ExceptionUtil;
import aiot.mclaren.senna.host.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lsj
 * @date 2021/2/7 14:20
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public DataResponse<Object> handleException(Exception e) {
        log.error(ExceptionUtil.exceptionDetailInfo(e));
        return DataResponse.error(e);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApiException.class)
    public DataResponse<Object> handleApiException(ApiException e) {
        log.error(ExceptionUtil.exceptionDetailInfo(e));
        return DataResponse.error((ResultCode)e);
    }
}
