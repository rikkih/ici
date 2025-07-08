package com.hoderick.ici.user.service;

import com.hoderick.ici.user.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto dto);
    UserDto getUser(UUID id);
}
