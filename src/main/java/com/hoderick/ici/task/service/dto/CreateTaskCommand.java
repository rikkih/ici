package com.hoderick.ici.task.service.dto;

import com.hoderick.ici.task.domain.model.TaskType;

public record CreateTaskCommand(String name, TaskType taskType) {
}
