package org.example.taskmanagementrestapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanagementrestapi.dto.TaskDTO;
import org.example.taskmanagementrestapi.model.Task;
import org.example.taskmanagementrestapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task Management API", description = "Endpoints for managing tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Get all tasks", description = "Retrieve a list of all tasks.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of tasks")
    })
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @Operation(summary = "Get a task by ID", description = "Retrieve a single task by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task found"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskByID(
            @Parameter(description = "ID of the task to retrieve", required = true) @PathVariable Long id) {
        Task task = taskService.getTask(id);
        return task == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(task);
    }

    @Operation(summary = "Create a new task", description = "Create a new task using the provided TaskDTO.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task created successfully")
    })
    @PostMapping
    public ResponseEntity<Task> createTask(
            @Parameter(description = "Task details", required = true) @RequestBody TaskDTO taskDTO) {
        Task task = taskService.createTask(taskDTO);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing task", description = "Update the details of an existing task by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task updated successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @Parameter(description = "ID of the task to update", required = true) @PathVariable Long id,
            @Parameter(description = "Updated task details", required = true) @RequestBody TaskDTO taskDTO) {
        Task updatedTask = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    @Operation(summary = "Delete a task", description = "Delete an existing task by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(
            @Parameter(description = "ID of the task to delete", required = true) @PathVariable Long id) {
        Task deletedTask = taskService.deleteTask(id);
        return ResponseEntity.ok(deletedTask);
    }
}
