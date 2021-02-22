package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.common.SecurityUtils;
import aiot.mclaren.senna.host.exception.ApiException;
import aiot.mclaren.senna.host.mapstruct.ProductConverter;
import aiot.mclaren.senna.host.service.ICategoryService;
import aiot.mclaren.senna.model.entity.Category;
import aiot.mclaren.senna.model.entity.Product;
import aiot.mclaren.senna.host.mapper.ProductMapper;
import aiot.mclaren.senna.host.service.IProductService;
import aiot.mclaren.senna.sdk.dto.ProductDTO;
import aiot.mclaren.senna.sdk.request.ProductBody;
import aiot.mclaren.senna.sdk.response.ErrorCode;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ICategoryService categoryService;

    @Transactional
    @Override
    public DataResponse<ProductDTO> create(ProductBody body) {
        Category category = categoryService.getById(body.getCategoryId());
        if (category == null) {
            throw new ApiException(ErrorCode.CATEGORY_NOT_FOUND);
        }
        Product product = ProductConverter.INSTANCE.toProductEntity(body);
        /* 默认节点类型直连设备(暂不开放设置) */
        product.setNodeType(1L);
        /* 默认设备秘钥方式(暂不开放设置) */
        product.setAuthType(1L);
        String secretId = SecurityUtils.getSecretId();
        product.setProductKey(secretId);
        product.setProductSecret(SecurityUtils.getSecretKey(secretId, product.getProductName()));
        boolean save = this.save(product);
        if (!save) {
            throw new ApiException(ErrorCode.DATABASE_OPERATION_EXCEPTION);
        }
        return DataResponse.success(ProductConverter.INSTANCE.toProductDTO(this.getById(product.getId())));
    }

}
