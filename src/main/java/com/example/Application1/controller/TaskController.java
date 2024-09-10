package com.example.Application1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Application1.entity.Task;
import com.example.Application1.service.TaskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        if (task.getTaskName()==null || task.getTaskName() == "") {
            return ResponseEntity.status(422).body("Please enter Task name");
        }

        if (task.getPriority() ==null) {
            return ResponseEntity.status(422).body("Please enter Priority");
        }

        taskService.createTask(task);
        return ResponseEntity.status(201).body("Task creat successfully");
    }
    
    @GetMapping("/getAllTask")
    public ResponseEntity<List<Task>> getAllTask() {
        return ResponseEntity.status(200).body(taskService.getTaskList());
    }

    @GetMapping("/getTaskById/{taskID}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskID){
        Task task = taskService.getTaskById(taskID);
        if (task == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(task);
        }
    }

    @PutMapping("updateTask/{taskID}")
    public ResponseEntity<Task> putMethodName(@PathVariable Long taskID, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(taskID, task);
        if (updatedTask != null) {
            return ResponseEntity.status(200).body(updatedTask);
        }

        return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/deleteTask/{taskID}")
    public void deleteTask(@PathVariable Long taskID) {
        taskService.deleteTask(taskID);
    }
    
}
