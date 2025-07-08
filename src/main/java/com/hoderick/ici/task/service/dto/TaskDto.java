package com.hoderick.ici.task.service.dto;

import com.hoderick.ici.task.domain.model.TaskStatus;
import com.hoderick.ici.task.domain.model.TaskType;

import java.util.UUID;

public record TaskDto(String name, String description, TaskType type, TaskStatus status, UUID requesterId) {
}
