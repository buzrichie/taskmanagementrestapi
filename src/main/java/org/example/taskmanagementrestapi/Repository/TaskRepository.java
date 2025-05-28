package org.example.taskmanagementrestapi.Repository;

import org.example.taskmanagementrestapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
