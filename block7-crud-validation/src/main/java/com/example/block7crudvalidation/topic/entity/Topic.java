package com.example.block7crudvalidation.topic.entity;

import com.example.block7crudvalidation.student.entity.Student;
import com.example.block7crudvalidation.teacher.entity.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue()
    Integer id_topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;

    @Column
    String topic;

    @Column
    String comments;


    @Column
    String initial_date;

    @Column
    String finish_date;

}
