package com.hoderick.ici.user.api.dto.response;

import com.hoderick.ici.user.domain.model.UserType;

import java.util.UUID;

public record HttpUserDto(UUID id, String name, String email, UserType type) {
}
