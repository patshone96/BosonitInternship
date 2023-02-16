package com.example.Block10docker.Person.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_person;
    @Column
    private String name;
    @Column
    private String adress;
    @Column
    private Integer phone;


}
