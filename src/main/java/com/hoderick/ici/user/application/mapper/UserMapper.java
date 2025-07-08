package com.hoderick.ici.user.application.mapper;

import com.hoderick.ici.user.application.dto.UserDto;
import com.hoderick.ici.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    User toDomain(UserDto dto);
}
