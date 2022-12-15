package com.example.block7crud.student.application;

import com.example.block7crud.exceptions.EmptyFieldsException;
import com.example.block7crud.exceptions.PersonNotFoundException;
import com.example.block7crud.student.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public Student addStudent(Student student);
    public Student modifyStudent(Student student, Integer id) throws PersonNotFoundException, EmptyFieldsException;
    public void deleteStudent(int id);
    public Student getStudent(int id) throws PersonNotFoundException;
//    public ArrayList<Student> getStudent(String name);
    public Iterable<Student> getAll();
}
