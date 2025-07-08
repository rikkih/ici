package com.hoderick.ici.task.service;

import com.hoderick.ici.task.service.dto.CreateTaskCommand;
import com.hoderick.ici.task.service.dto.TaskDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskDto createTask(CreateTaskCommand command);

    List<TaskDto> getTasks();

    TaskDto getTask(UUID id);
}
