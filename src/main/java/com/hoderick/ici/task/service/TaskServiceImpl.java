package com.hoderick.ici.task.service;

import com.hoderick.ici.task.domain.event.TaskCreatedEvent;
import com.hoderick.ici.task.domain.model.Task;
import com.hoderick.ici.task.domain.repository.TaskRepository;
import com.hoderick.ici.task.service.dto.CreateTaskCommand;
import com.hoderick.ici.task.service.dto.TaskDto;
import com.hoderick.ici.task.service.mapper.TaskServiceMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskServiceMapper taskServiceMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional
    public TaskDto createTask(CreateTaskCommand command) {
        Task task = taskServiceMapper.fromCreateTaskCommand(command);
        Task savedTask = taskRepository.save(task);
        eventPublisher.publishEvent(new TaskCreatedEvent(savedTask.getId()));
        return taskServiceMapper.toDto(savedTask);
    }

    @Override
    public List<TaskDto> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(taskServiceMapper::toDto)
                .toList();
    }

    @Override
    public TaskDto getTask(UUID id) {
        return null;
    }
}
