package com.hoderick.ici.task.api.mapper;

import com.hoderick.ici.task.api.dto.request.CreateTaskRequest;
import com.hoderick.ici.task.api.dto.response.TaskResponse;
import com.hoderick.ici.task.service.dto.CreateTaskCommand;
import com.hoderick.ici.task.service.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskApiMapper {

    TaskApiMapper INSTANCE = Mappers.getMapper(TaskApiMapper.class);

    TaskResponse toResponse(TaskDto taskDto);

    CreateTaskCommand toCreateTaskCommand(CreateTaskRequest createTaskRequest);
}
