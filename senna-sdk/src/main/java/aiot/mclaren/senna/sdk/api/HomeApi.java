package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhiwen.zuo
 * @date 2021-01-29
 **/
@RequestMapping("home")
@Api(tags = "首页")
public interface HomeApi {
    @ApiOperation("默认")
    @GetMapping
    DataResponse<Long> index();
}
