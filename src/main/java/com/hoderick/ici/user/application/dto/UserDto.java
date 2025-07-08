package com.hoderick.ici.user.application.dto;

import com.hoderick.ici.user.domain.model.UserType;
import org.springframework.modulith.NamedInterface;

import java.util.UUID;

@NamedInterface
public record UserDto(UUID id, String name, String email, UserType type) {
}
