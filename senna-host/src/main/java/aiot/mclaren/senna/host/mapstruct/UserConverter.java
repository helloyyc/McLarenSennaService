package aiot.mclaren.senna.host.mapstruct;

import aiot.mclaren.senna.model.entity.User;
import aiot.mclaren.senna.sdk.dto.UserDTO;
import aiot.mclaren.senna.sdk.request.UserRegisterBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author lsj
 * @date 2021/2/6 20:07
 */
@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User toUserEntity(UserRegisterBody body);

    UserDTO toUserDTO(User user);
}
