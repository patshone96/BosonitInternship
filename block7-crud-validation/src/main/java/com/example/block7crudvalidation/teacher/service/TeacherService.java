package com.example.block7crudvalidation.teacher.service;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.teacher.entity.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    public Teacher getTeacher(Integer id) throws EntityNotFoundException;
    public Iterable<Teacher> getAll();
    public Teacher addTeacher(Teacher teacher) throws UnprocessableEntityException;

    public void deleteTeacher(Integer id) throws EntityNotFoundException;
}
