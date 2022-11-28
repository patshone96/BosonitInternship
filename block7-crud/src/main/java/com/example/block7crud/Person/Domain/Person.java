package com.example.block7crud.Person.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue //Auto generated value  for the ID
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String city;



}
