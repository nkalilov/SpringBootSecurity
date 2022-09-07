package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository {

    void saveTask(Long lessonId, Task task);

    void updateTask(Long id,Task task);

    Task getTaskById(Long id);

    List<Task> getAllTasks(Long id);

    void deleteTaskById(Long id);
}