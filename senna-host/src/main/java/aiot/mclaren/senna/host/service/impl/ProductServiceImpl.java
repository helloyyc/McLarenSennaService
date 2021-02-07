package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.commons.response.DefaultCode;
import aiot.mclaren.senna.host.common.SecurityUtils;
import aiot.mclaren.senna.host.exception.ApiException;
import aiot.mclaren.senna.host.mapstruct.ProductConverter;
import aiot.mclaren.senna.model.constant.ErrorCode;
import aiot.mclaren.senna.model.entity.Product;
import aiot.mclaren.senna.host.mapper.ProductMapper;
import aiot.mclaren.senna.host.service.IProductService;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public DataResponse<ProductDTO> create(ProductBody body) {
        Product product = ProductConverter.INSTANCE.toProductEntity(body);
        String secretId = SecurityUtils.getSecretId();
        product.setProductKey(secretId);
        product.setProductSecret(SecurityUtils.getSecretKey(secretId, product.getProductName()));
        boolean save = this.save(product);
        if (!save) {
            throw new ApiException(DefaultCode.UNKNOWN_ERROR);
        }
        return DataResponse.success(ProductConverter.INSTANCE.toProductDTO(this.getById(product.getId())));
    }

}
