package com.task.app.service;

import com.task.app.entity.Task;
import com.task.app.repository.TaskAppRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskAppService {
    @Autowired
    private TaskAppRepository taskAppRepository;
    public List<Task> getAllTasks() {
        return taskAppRepository.findAll();
    }

    public void createNewTask(Task task) {
       taskAppRepository.save(task);
    }

    public void updateTask(Long id, Task task) {
        Task actualTask = taskAppRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Task não encontrada: {id}"));
        actualTask.setText(task.getText());
        actualTask.setCompleted(task.isCompleted());
        taskAppRepository.save(actualTask);
    }

    public void deleteTask(Long id) {
        taskAppRepository.deleteById(id);
    }
}
