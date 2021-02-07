package aiot.mclaren.senna.host.mapstruct;

import aiot.mclaren.senna.model.entity.Product;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author lsj
 * @date 2021/2/7 17:02
 */
@Mapper
public interface ProductConverter {
    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    Product toProductEntity(ProductBody body);

    ProductDTO toProductDTO(Product product);
}
