package com.hoderick.ici.user.application.service;

import com.hoderick.ici.user.application.dto.UserDto;
import org.springframework.modulith.NamedInterface;

import java.util.UUID;

@NamedInterface
public interface UserService {
    UserDto getUserById(UUID id);
}
