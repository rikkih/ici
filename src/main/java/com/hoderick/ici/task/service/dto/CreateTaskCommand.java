package com.hoderick.ici.task.service.dto;

import com.hoderick.ici.task.api.dto.request.LocationDto;
import com.hoderick.ici.task.domain.model.TaskType;

import java.util.UUID;

public record CreateTaskCommand(
        String name,
        TaskType taskType,
        String description,
        UUID requesterId,
        LocationDto location) {
}
