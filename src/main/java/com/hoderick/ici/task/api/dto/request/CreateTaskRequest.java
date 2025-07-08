package com.hoderick.ici.task.api.dto.request;

import com.hoderick.ici.task.domain.model.TaskType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest(
        @NotNull(message = "Task must have a name")
        String name,
        @NotBlank
        @Size(max = 100)
        TaskType type
) {
}
