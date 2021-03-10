package aiot.mclaren.senna.host.mapstruct;

import aiot.mclaren.senna.model.entity.ThingConfig;
import aiot.mclaren.senna.sdk.dto.ThingConfigDTO;
import aiot.mclaren.senna.sdk.response.PageList;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author lsj
 * @date 2021/3/10 10:30
 */
@Mapper
public interface ThingConfigConverter {
    ThingConfigConverter INSTANCE = Mappers.getMapper(ThingConfigConverter.class);

    ThingConfigDTO toThingConfigDTO(ThingConfig config);

    PageList<ThingConfigDTO> toThingConfigDTOPages(IPage<ThingConfig> page);

}
