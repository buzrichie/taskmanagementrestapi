package org.example.taskmanagementrestapi.service;

import org.example.taskmanagementrestapi.repository.TaskRepository;
import org.example.taskmanagementrestapi.dto.TaskDTO;
import org.example.taskmanagementrestapi.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() { return repository.findAll(); }
    public Task createTask(TaskDTO dto) {
        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        System.out.println(task);
        return repository.save(task);
    }
    public Task getTask(Long id) { return repository.findById(id).orElse(null); }

    public Task updateTask(Long id, TaskDTO dto) {
        Task task = repository.findById(id).orElseThrow();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        return repository.save(task);
    }
    public Task deleteTask(Long id) {
        Task task = repository.findById(id).orElseThrow();
        repository.deleteById(task.getId());
        return task;
    }
}

