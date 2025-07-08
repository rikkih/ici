package com.hoderick.ici.task.service.mapper;

import com.hoderick.ici.task.domain.model.Task;
import com.hoderick.ici.task.service.dto.CreateTaskCommand;
import com.hoderick.ici.task.service.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskServiceMapper {

    TaskServiceMapper INSTANCE = Mappers.getMapper(TaskServiceMapper.class);

    TaskDto toDto(Task task);

    Task fromCreateTaskCommand(CreateTaskCommand createTaskCommand);
}
