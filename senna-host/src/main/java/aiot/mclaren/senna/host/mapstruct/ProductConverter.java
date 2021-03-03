package aiot.mclaren.senna.host.mapstruct;

import aiot.mclaren.senna.model.entity.Product;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import aiot.mclaren.senna.sdk.response.SimplePage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author lsj
 * @date 2021/2/7 17:02
 */
@Mapper
public interface ProductConverter {
    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    Product toProduct(ProductBody body);

    ProductDTO toProductDTO(Product product);

    SimplePage<ProductDTO> toProductDTOPages(IPage<Product> page);
}
