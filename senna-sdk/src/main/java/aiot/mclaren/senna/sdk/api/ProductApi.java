package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.commons.response.PageListResponse;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import aiot.mclaren.senna.sdk.request.ProductQuery;
import aiot.mclaren.senna.sdk.response.SimplePage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lsj
 * @date 2021/2/6 16:45
 */
@Api(tags = "产品")
@FeignClient(name = "${spring.application.name}", contextId = "product")
@RequestMapping("products")
public interface ProductApi {

    @ApiOperation("创建产品")
    @PostMapping
    DataResponse<ProductDTO> create(@Validated @RequestBody ProductBody body);

    @ApiOperation("产品列表")
    @GetMapping
    DataResponse<SimplePage<ProductDTO>> selectPage(@Validated ProductQuery query);
}
