package aiot.mclaren.senna.host.service;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.model.entity.Product;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import aiot.mclaren.senna.sdk.request.ProductQuery;
import aiot.mclaren.senna.sdk.response.SimplePage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
public interface IProductService extends IService<Product> {

    Product getByProductKey(String productKey);

    DataResponse<ProductDTO> create(ProductBody body);

    DataResponse<SimplePage<ProductDTO>> selectPage(ProductQuery query);
}
