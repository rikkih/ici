package com.hoderick.ici.task.api.dto.request;

import com.hoderick.ici.task.domain.model.TaskType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateTaskRequest(
        @NotBlank(message = "Task must have a name")
        @Size(max = 100, message = "Task name must be at most 100 characters")
        String name,

        @NotBlank(message = "Description must not be blank")
        @Size(max = 500, message = "Description must be at most 500 characters")
        String description,

        // TODO: Think about creating a public facing enum so as to hide internal details
        @NotNull(message = "Task type is required")
        TaskType taskType,

        @NotNull(message = "A task needs a valid Requester")
        UUID requesterId
) {
}
