package aiot.mclaren.senna.host.controller;


import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.service.IProductService;
import aiot.mclaren.senna.sdk.api.ProductApi;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

