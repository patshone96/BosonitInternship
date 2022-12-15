package com.example.block7crudvalidation.student.application;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.student.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public Student addStudent(Student student);
    public Student modifyStudent(Student student, Integer id) throws EntityNotFoundException, UnprocessableEntityException;
    public void deleteStudent(int id);
    public Student getStudent(int id) throws EntityNotFoundException;
    public Iterable<Student> getAll();
}
