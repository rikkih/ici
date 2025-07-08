package com.hoderick.ici.user.api.mapper;

import com.hoderick.ici.user.api.dto.response.HttpUserDto;
import com.hoderick.ici.user.api.dto.request.CreateUserRequest;
import com.hoderick.ici.user.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserApiMapper {

    HttpUserDto toHttpDto(User user);

    User fromCreateRequest(CreateUserRequest request);
}
