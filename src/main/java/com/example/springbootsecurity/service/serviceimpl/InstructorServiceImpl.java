package com.example.springbootsecurity.service.serviceimpl;

import com.example.springbootsecurity.entity.Instructor;
import com.example.springbootsecurity.repository.InstructorRepository;
import com.example.springbootsecurity.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void saveInstructor(Long id, Instructor instructor) {
        instructorRepository.saveInstructor(id,instructor);
    }

    @Override
    public void updateInstructor(Long id,Instructor instructor) {
        instructorRepository.updateInstructor(id,instructor);
    }

    @Override
    public List<Instructor> getAllInstructor(Long id) {
        return instructorRepository.getAllInstructor(id);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorRepository.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignInstructorToCourse(instructorId,courseId);
    }

}
