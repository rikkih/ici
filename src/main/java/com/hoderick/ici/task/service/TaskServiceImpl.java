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

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskServiceMapper taskServiceMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional
    public TaskDto createTask(CreateTaskCommand command) {
        Task task = Task.fromCommand(command);
        Task savedTask = taskRepository.save(task);
        publishTaskCreatedEvent(savedTask);
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
        return taskRepository.findById(id)
                .map(taskServiceMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("No Task found with ID: {}" + id));
    }

    private void publishTaskCreatedEvent(Task task) {
        double longitude = task.getLocation().getLongitude();
        double latitude = task.getLocation().getLatitude();
        eventPublisher.publishEvent(new TaskCreatedEvent(task.getId(), task.getRequesterId(), longitude, latitude));
    }
}
