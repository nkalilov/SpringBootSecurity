package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository {

    void saveInstructor(Long id, Instructor instructor);

    void updateInstructor(Long id,Instructor instructor);

    List<Instructor> getAllInstructor(Long id);

    Instructor getInstructorById(Long id);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long instructorId,Long courseId);
}