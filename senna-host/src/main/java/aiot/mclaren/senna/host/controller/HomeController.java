package aiot.mclaren.senna.host.controller;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.sdk.api.HomeApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen.zuo
 * @date 2021-01-29
 **/
@Slf4j
@RestController
public class HomeController implements HomeApi {
    @Override
    public DataResponse<Long> index() {
        return DataResponse.success(System.currentTimeMillis());
    }
}
