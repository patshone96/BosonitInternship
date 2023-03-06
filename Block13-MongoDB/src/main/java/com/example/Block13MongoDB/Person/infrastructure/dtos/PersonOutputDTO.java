package com.example.Block13MongoDB.Person.infrastructure.dtos;


import com.example.Block13MongoDB.Person.model.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PersonOutputDTO {


    long id;
    String usr;
    String name;
    String surname;
    String city;
    String companyMail;
    Boolean active;
    String imageUrl;

    public PersonOutputDTO(Person person){
        this.id = person.getId();
        this.usr = person.getUsr();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.city = person.getCity();
        this.companyMail = person.getCompanyMail();
        this.active = person.getActive();
        this.imageUrl = person.getImageUrl();

    }


}
