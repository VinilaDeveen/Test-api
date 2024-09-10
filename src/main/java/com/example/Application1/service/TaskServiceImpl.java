package com.example.Application1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Application1.entity.Task;
import com.example.Application1.repository.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public List<Task> getTaskList() {
        return taskRepo.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task getTaskById(Long taskID) {
        return taskRepo.findById(taskID).orElse(null);
    }

    @Override
    public Task updateTask(Long taskID, Task task) {
        Task existingTask = taskRepo.findById(taskID).orElse(null);

        if (existingTask != null) {
            existingTask.setTaskName(task.getTaskName());
            existingTask.setPriority(task.getPriority());
            existingTask.setDueDate(task.getDueDate());
            return taskRepo.save(existingTask);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTask(Long taskID) {
        taskRepo.deleteById(taskID);
    }

    
}
