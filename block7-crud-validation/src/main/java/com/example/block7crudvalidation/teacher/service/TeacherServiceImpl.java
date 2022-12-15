package com.example.block7crudvalidation.teacher.service;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.teacher.entity.Teacher;
import com.example.block7crudvalidation.teacher.infrastructure.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public Teacher getTeacher(Integer id) throws EntityNotFoundException {
        if(teacherRepo.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }else{
            return teacherRepo.findById(id).get();
        }
    }

    @Override
    public Iterable<Teacher> getAll() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) throws UnprocessableEntityException {
        return teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacher(Integer id) throws EntityNotFoundException {
        teacherRepo.deleteById(id);
    }
}
