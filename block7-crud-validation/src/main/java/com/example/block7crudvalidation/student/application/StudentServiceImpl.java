package com.example.block7crudvalidation.student.application;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.student.entity.Student;
import com.example.block7crudvalidation.student.infrastructure.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student modifyStudent(Student student, Integer id) throws EntityNotFoundException, UnprocessableEntityException {
        Optional<Student> op = studentRepo.findById(id); //We look for a student on the repository

        if (op.isPresent()){ //If the student exists...

            Student st = op.get(); //We retrieve the data of said student

            //Check for the data provided to modify a student
            //If any field is empty, we throw an exception
            if(st.getBranch().length()<1 || st.getHoursPerWeek().toString().length()<1){
                throw new UnprocessableEntityException();
            }

            //We change the student's data to the provided one
            st.setBranch(student.getBranch());
            st.setComments(student.getComments());
            st.setHoursPerWeek(student.getHoursPerWeek());

            //We return the modified student
            return studentRepo.save(st);
        }else{ //If the person to change does not exist on the repo we throw an exception
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void deleteStudent(int id) {
            studentRepo.deleteById(id);
    }

    @Override
    public Student getStudent(int id) throws EntityNotFoundException {
        if(studentRepo.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }else{
            return studentRepo.findById(id).get();
        }
    }


    @Override
    public Iterable<Student> getAll() {
        return studentRepo.findAll();
    }
}
