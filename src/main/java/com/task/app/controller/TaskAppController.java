package com.task.app.controller;

import com.task.app.entity.Task;
import com.task.app.service.TaskAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/")
public class TaskAppController {

    @Autowired
    private TaskAppService taskAppService;
    @GetMapping
    public List<Task> getAllTasks() {
        return taskAppService.getAllTasks();
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskAppService.createNewTask(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskAppService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskAppService.deleteTask(id);
    }

}
