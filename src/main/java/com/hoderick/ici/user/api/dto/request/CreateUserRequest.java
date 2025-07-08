package com.hoderick.ici.user.api.dto.request;

import com.hoderick.ici.user.domain.model.UserType;

public record CreateUserRequest(String name, String email, UserType type) {
}
