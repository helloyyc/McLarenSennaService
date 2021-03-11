package aiot.mclaren.senna.host.service.impl;

import aiot.mclaren.senna.model.entity.Tag;
import aiot.mclaren.senna.host.mapper.TagMapper;
import aiot.mclaren.senna.host.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
