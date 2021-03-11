package aiot.mclaren.senna.host.component;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.commons.util.ExceptionUtil;
import aiot.mclaren.senna.sdk.exception.ApiException;
import aiot.mclaren.senna.sdk.response.ErrorDataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        log.warn(ExceptionUtil.exceptionDetailInfo(e));
        e.printStackTrace();
        return DataResponse.error(e);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ErrorDataResponse<Object> handleBindException(BindException e) {
        log.warn(ExceptionUtil.exceptionDetailInfo(e));
        return ErrorDataResponse.error(e.getBindingResult());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDataResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn(ExceptionUtil.exceptionDetailInfo(e));
        return ErrorDataResponse.error(e.getBindingResult());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApiException.class)
    public DataResponse<Object> handleApiException(ApiException e) {
        log.warn(ExceptionUtil.exceptionDetailInfo(e));
        return ErrorDataResponse.error(e);
    }
}
