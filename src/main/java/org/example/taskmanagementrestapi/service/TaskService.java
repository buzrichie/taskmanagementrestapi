package org.example.taskmanagementrestapi.service;

import org.example.taskmanagementrestapi.Repository.TaskRepository;
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
    public Task createTask(Task task) { return repository.save(task); }
    public Task getTask(Long id) { return repository.findById(id).orElse(null); }
    public Task updateTask(Long id, Task taskDetails) {
        Task task = repository.findById(id).orElseThrow();

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());

        return repository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = repository.findById(id).orElseThrow();
        repository.deleteById(task.getId());
    }
}

