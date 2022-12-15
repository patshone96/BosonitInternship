package com.example.block7crud.student.entity;

import com.example.block7crud.person.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    Integer student_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", nullable = false, unique = true)
    private Person person;

    @Column(nullable = false)
    private Integer hoursPerWeek;

    @Column
    private String comments;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_teacher", nullable = false)
//    private Teacher teacher;

    @NotNull
    @Column
    private String branch;







}
