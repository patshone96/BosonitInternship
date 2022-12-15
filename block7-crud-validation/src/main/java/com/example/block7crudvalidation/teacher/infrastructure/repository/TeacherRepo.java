package com.example.block7crudvalidation.teacher.infrastructure.repository;

import com.example.block7crudvalidation.teacher.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
}
