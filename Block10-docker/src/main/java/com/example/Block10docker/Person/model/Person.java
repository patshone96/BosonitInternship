package com.example.Block10docker.Person.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private Integer id_person;
    @Column
    private String name;
    @Column
    private String adress;
    @Column
    private Integer phone;


}
