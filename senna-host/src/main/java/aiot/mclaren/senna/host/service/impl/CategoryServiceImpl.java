package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.model.entity.Category;
import aiot.mclaren.senna.host.mapper.CategoryMapper;
import aiot.mclaren.senna.host.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-02-07
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
