package aiot.mclaren.senna.host.component;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.commons.response.ResultCode;
import aiot.mclaren.commons.util.ExceptionUtil;
import aiot.mclaren.senna.host.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lsj
 * @date 2021/2/7 14:20
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    public DataResponse<Object> handleApiException(ApiException e) {
        log.error(ExceptionUtil.exceptionDetailInfo(e));
        return DataResponse.error((ResultCode)e);
    }
}
