package com.hoderick.ici.task.domain.repository;

import com.hoderick.ici.task.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
