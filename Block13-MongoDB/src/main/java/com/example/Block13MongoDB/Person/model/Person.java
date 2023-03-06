package com.example.Block13MongoDB.Person.model;

import lombok.*;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "People")
public class Person {

    @Id
    private long id;

    private String usr;
    private String password;
    private String name;
    private String surname;
    private String city;
    private String companyMail;
    private String personalMail;
    private Boolean active;
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;




}
