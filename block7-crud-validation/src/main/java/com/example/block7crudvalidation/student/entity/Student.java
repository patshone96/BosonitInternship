package com.example.block7crudvalidation.student.entity;
import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.teacher.entity.Teacher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue
    Integer student_id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(nullable = false)
    private Integer hoursPerWeek;

    @Column
    private String comments;

     @ManyToOne()
     @JoinColumn(name = "id_teacher")
     private Teacher teacher;

    @NotNull
    @Column
    private String branch;


    public Student(Person person, Integer hourPerWeek, String comment, String branch) {
    }
}
