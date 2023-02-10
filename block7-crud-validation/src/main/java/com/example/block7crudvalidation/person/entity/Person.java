package com.example.block7crudvalidation.person.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue //Auto generated value  for the ID
    private Integer person_id;

    @Column
    private String usr;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String city;

    @Column
    private String companyMail;

    @Column
    private String personalMail;

    @Column
    private Boolean active;

    @Column
    private Date createdDate;

    @Column
    private String imageUrl;

    @Column
    private Date terminationDate;



}
