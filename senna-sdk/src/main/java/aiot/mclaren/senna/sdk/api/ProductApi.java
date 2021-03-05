package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import aiot.mclaren.senna.sdk.request.ProductQuery;
import aiot.mclaren.senna.sdk.response.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("产品详情")
    @GetMapping("{id}")
    DataResponse<ProductDTO> getById(@PathVariable Long id);

    @ApiOperation("产品列表")
    @GetMapping
    DataResponse<PageList<ProductDTO>> listPage(@Validated ProductQuery query);
}
