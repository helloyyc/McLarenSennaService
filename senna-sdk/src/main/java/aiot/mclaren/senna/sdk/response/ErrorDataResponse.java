package aiot.mclaren.senna.sdk.response;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.commons.response.ResultCode;
import aiot.mclaren.senna.sdk.exception.ApiException;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lsj
 * @date 2021/2/8 10:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("包含错误信息的返回")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDataResponse<T> extends DataResponse<T> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("错误信息")
    private Map<String, Object> errors;


    public ErrorDataResponse(ResultCode code, Map<String, Object> errors) {
        super(code);
        this.errors = errors;
    }

    public static <T> ErrorDataResponse<T> error(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, Object> errors = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ErrorDataResponse<>(ErrorCode.ARGUMENT_ILLEGAL, errors);
    }

    public static <T> ErrorDataResponse<T> error(ApiException e) {
        return new ErrorDataResponse<>(e, e.getErrors());
    }
}
