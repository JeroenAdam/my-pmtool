package com.adambahri.mypmtool.web;


import com.adambahri.mypmtool.domain.Task;
import com.adambahri.mypmtool.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/active")
    public ResponseEntity<List<Task>> getAllActiveTasks() {
        List<Task> activeTasks = taskService.getAllActiveTasks();
        return ResponseEntity.ok(activeTasks);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/by-parent-message/{parentMessageId}")
    public ResponseEntity<Task> getTaskByParentMessageId(@PathVariable String parentMessageId) {
        Task task = taskService.getTaskByParentMessageId(parentMessageId);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.accepted().build();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @PatchMapping("/{id}")
    public Task updateTaskPartial(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTaskPartial(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

