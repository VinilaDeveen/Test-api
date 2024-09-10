package com.example.Application1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Application1.entity.Task;

@Service
public interface TaskService {
    List<Task> getTaskList();
    Task createTask(Task task);
    Task getTaskById(Long taskID);
    Task updateTask(Long taskID, Task task);
    void deleteTask(Long taskID);
}
