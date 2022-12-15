package com.example.block7crudvalidation.teacher.entity;

import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.student.entity.Student;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {

    @Id
    @GeneratedValue
    private Integer teacher_id;

    @OneToOne()
    @JoinColumn(name="id_person", nullable = false)
    private Person person;

    @OneToMany()
    @JoinColumn(name="id_student")
    private List<Student> students;


    @Column
    private String comments;

    @Column(nullable = false)
    private String branch;


    public Teacher(Person person, String comments, String branch) {;
        this.person = person;
        this.comments = comments;
        this.branch = branch;
    }


}
