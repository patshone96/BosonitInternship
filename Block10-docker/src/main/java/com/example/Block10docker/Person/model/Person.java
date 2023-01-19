package com.example.Block10docker.Person.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@Data
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private Integer ident;

    @Column(name = "name")
    private String name;

    @Column(name = "adress")
    private String adress;

    @Column(name= "phone")
    private Integer phone;


}
