package com.hoderick.ici.user.dto;

import com.hoderick.ici.user.domain.model.UserType;

import java.util.UUID;

public record UserDto(UUID id, String name, String email, UserType userType) {
}
