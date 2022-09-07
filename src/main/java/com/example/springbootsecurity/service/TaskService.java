package com.example.springbootsecurity.service;

import com.example.springbootsecurity.entity.Task;

import java.util.List;

public interface TaskService {
    void saveTask(Long lessonId, Task task);

    void updateTask(Long id,Task task);

    Task getTaskById(Long id);

    List<Task> getAllTasks(Long id);

    void deleteTaskById(Long id);
}
