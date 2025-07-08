package com.hoderick.ici.task.api;

import com.hoderick.ici.task.api.dto.request.CreateTaskRequest;
import com.hoderick.ici.task.api.dto.response.TaskResponse;
import com.hoderick.ici.task.api.mapper.TaskApiMapper;
import com.hoderick.ici.task.service.TaskService;
import com.hoderick.ici.task.service.dto.CreateTaskCommand;
import com.hoderick.ici.task.service.dto.TaskDto;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class TaskController {

    private final TaskService taskService;
    private final TaskApiMapper taskApiMapper;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getTasks() {
        List<TaskResponse> taskResponses = taskService.getTasks()
                .stream()
                .map(taskApiMapper::toResponse)
                .toList();
        return ResponseEntity.ok().body(taskResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(taskApiMapper.toResponse(taskService.getTask(id)));
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest createTaskRequest) {
        CreateTaskCommand createTaskCommand = taskApiMapper.toCreateTaskCommand(createTaskRequest);
        TaskDto taskDto = taskService.createTask(createTaskCommand);

        return ResponseEntity.ok().body(taskApiMapper.toResponse(taskDto));
    }
}
