package com.example.springbootsecurity.service;

import com.example.springbootsecurity.entity.Lesson;

import java.util.List;

public interface LessonService {

    void saveLesson(Long courseId, Lesson lesson);

    void updateLesson(Long id,Lesson lesson);

    List<Lesson> getAllLessons(Long id);

    Lesson getLessonById(Long id);

    void deleteLessonById(Long id);
}
