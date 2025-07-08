package com.hoderick.ici.task.service.dto;

import com.hoderick.ici.task.domain.model.TaskType;

public record TaskDto(String name, String description, TaskType type) {
}
