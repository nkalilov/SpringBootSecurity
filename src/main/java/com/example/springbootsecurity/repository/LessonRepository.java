package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository {

    void saveLesson(Long courseId, Lesson lesson);

    void updateLesson(Long id,Lesson lesson);

    List<Lesson> getAllLessons(Long id);

    Lesson getLessonById(Long id);

    void deleteLessonById(Long id);
}