package com.hoderick.ici.task.domain.model;

import com.hoderick.ici.common.Auditable;
import com.hoderick.ici.task.service.dto.CreateTaskCommand;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
public class Task extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TaskType type;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private String name;
    private String description;
    @Embedded
    private Location location;
    private UUID requesterId;

    private Task(String name, String description, TaskType type, Location location, UUID requesterId) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.location = location;
        this.requesterId = requesterId;
        this.status = TaskStatus.REQUESTED;
    }

    public static Task fromCommand(CreateTaskCommand command) {
        return new Task(
                command.name(),
                command.description(),
                command.taskType(),
                new Location(command.location().longitude(), command.location().latitude()),
                command.requesterId()
        );
    }
}
