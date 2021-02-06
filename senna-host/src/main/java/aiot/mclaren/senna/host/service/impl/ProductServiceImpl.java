package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.model.entity.Product;
import aiot.mclaren.senna.host.mapper.ProductMapper;
import aiot.mclaren.senna.host.service.IProductService;
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

}
