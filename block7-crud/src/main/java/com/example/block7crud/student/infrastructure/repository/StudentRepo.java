package com.example.block7crud.student.infrastructure.repository;

import com.example.block7crud.student.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

    //We add this funtion that performs a Query that returns all entries for a given name.
    //Returns an empty list if there aren't entries with that name
//    @Query("SELECT s FROM Student s WHERE s.name = :name")
//    ArrayList<Student> findStudentByName(String name);
}
