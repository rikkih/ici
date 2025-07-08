package com.hoderick.ici.user.dto;

import com.hoderick.ici.user.domain.model.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserDto(
        UUID id,

        @NotBlank
        String name,

        @Email
        @NotBlank
        String email,

        @NotNull
        UserType userType) {
}
