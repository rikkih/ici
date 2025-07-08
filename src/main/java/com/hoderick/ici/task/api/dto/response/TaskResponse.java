package com.hoderick.ici.task.api.dto.response;

import com.hoderick.ici.task.domain.model.TaskStatus;
import com.hoderick.ici.task.domain.model.TaskType;

public record TaskResponse(String name, String description, TaskType type, TaskStatus status) {
}
