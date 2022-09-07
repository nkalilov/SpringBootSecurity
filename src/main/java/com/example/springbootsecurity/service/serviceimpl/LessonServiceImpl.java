package com.example.springbootsecurity.service.serviceimpl;

import com.example.springbootsecurity.entity.Lesson;
import com.example.springbootsecurity.repository.LessonRepository;
import com.example.springbootsecurity.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        lessonRepository.saveLesson(courseId,lesson);
    }

    @Override
    public void updateLesson(Long id,Lesson lesson) {
        lessonRepository.updateLesson(id,lesson);
    }

    @Override
    public List<Lesson> getAllLessons(Long id) {
        return lessonRepository.getAllLessons(id);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }

    @Override
    public void deleteLessonById(Long id) {
        lessonRepository.deleteLessonById(id);
    }
}
