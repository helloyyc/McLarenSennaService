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
import aiot.mclaren.senna.sdk.request.ProductQuery;
import aiot.mclaren.senna.sdk.response.ErrorCode;
import aiot.mclaren.senna.sdk.response.SimplePage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ICategoryService categoryService;

    @Override
    public Product getByProductKey(String productKey) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_key",productKey);
        return this.getOne(queryWrapper);
    }

    @Transactional
    @Override
    public DataResponse<ProductDTO> create(ProductBody body) {
        Category category = categoryService.getById(body.getCategoryId());
        if (category == null) {
            throw new ApiException(ErrorCode.CATEGORY_NOT_FOUND);
        }
        Product product = ProductConverter.INSTANCE.toProduct(body);
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

    @Override
    public DataResponse<SimplePage<ProductDTO>> selectPage(ProductQuery query) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(query.getProductName())) {
            queryWrapper.like("product_name", query.getProductName());
        }
        IPage<Product> page = new Page<>(query.getPage(), query.getSize());
        return DataResponse.success(ProductConverter.INSTANCE.toProductDTOPages(page(page, queryWrapper)));
    }

}
