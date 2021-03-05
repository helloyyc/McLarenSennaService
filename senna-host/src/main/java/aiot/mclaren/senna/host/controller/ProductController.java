package aiot.mclaren.senna.host.controller;


import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.mapstruct.ProductConverter;
import aiot.mclaren.senna.host.service.IProductService;
import aiot.mclaren.senna.sdk.api.ProductApi;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import aiot.mclaren.senna.sdk.request.ProductQuery;
import aiot.mclaren.senna.sdk.response.PageList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@RestController
public class ProductController implements ProductApi {

    @Autowired
    private IProductService productService;

    @Override
    public DataResponse<ProductDTO> create(ProductBody body) {
        return productService.create(body);
    }

    @Override
    public DataResponse<ProductDTO> getById(Long id) {
        return DataResponse.success(ProductConverter.INSTANCE.toProductDTO(productService.getById(id)));
    }

    @Override
    public DataResponse<PageList<ProductDTO>> listPage(ProductQuery query) {
        return productService.queryPage(query);
    }
}

