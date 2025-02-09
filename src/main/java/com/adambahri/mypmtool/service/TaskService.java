package com.adambahri.mypmtool.service;

import com.adambahri.mypmtool.domain.Task;
import com.adambahri.mypmtool.repository.TaskRepository;
import com.adambahri.mypmtool.web.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getAllActiveTasks() {
        return taskRepository.findByStatusNot("done");
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
    }

    public Task getTaskByParentMessageId(String parentMessageId) {
        System.out.println("🔍 Debug: Fetching task by parentMessageId = " + parentMessageId);
        return taskRepository.findByParentMessageId(parentMessageId);
    }

    public Task createTask(Task task) {
        task.setCreated(new Date());
        task.setUpdated(new Date());
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        task.setTitle(taskDetails.getTitle());
        task.setChannelId(taskDetails.getChannelId());
        task.setParentMessageId(taskDetails.getParentMessageId());
        task.setStatus(taskDetails.getStatus());
        task.setOwner(taskDetails.getOwner());
        task.setAssignee(taskDetails.getAssignee());
        task.setTag(taskDetails.getTag());
        task.setPrio(taskDetails.getPrio());
        task.setDeadline(taskDetails.getDeadline());
        task.setImportant(taskDetails.getImportant());
        task.setUrgent(taskDetails.getUrgent());
        task.setUpdated(new Date());
        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTaskPartial(Long id, Task taskDetails) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        // Only update fields that are provided in request
        if (taskDetails.getUpdated() != null) {
            existingTask.setUpdated(taskDetails.getUpdated());
        }
        if (taskDetails.getTitle() != null) {
            existingTask.setTitle(taskDetails.getTitle());
        }
        if (taskDetails.getStatus() != null) {
            existingTask.setStatus(taskDetails.getStatus());
        }
        if (taskDetails.getAssignee() != null) {
            existingTask.setAssignee(taskDetails.getAssignee());
        }
        if (taskDetails.getTag() != null) {
            existingTask.setTag(taskDetails.getTag());
        }
        return taskRepository.save(existingTask);
    }


    @Transactional
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
