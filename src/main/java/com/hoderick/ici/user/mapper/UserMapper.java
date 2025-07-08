package com.hoderick.ici.user.mapper;

import com.hoderick.ici.user.domain.model.User;
import com.hoderick.ici.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userType", ignore = true)
    UserDto toDto(User user);

    User fromDto(UserDto dto);
}
