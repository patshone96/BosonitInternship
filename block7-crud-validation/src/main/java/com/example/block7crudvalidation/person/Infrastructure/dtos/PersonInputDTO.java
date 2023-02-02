package com.example.block7crudvalidation.person.Infrastructure.dtos;

import com.example.block7crudvalidation.person.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO {

    private Integer person_id;
    private String usr;
    private String password;
    private String name;
    private String surname;
    private String city;
    private String companyMail;
    private String personalMail;
    private Boolean active;
    private String createdDate;
    private String imageUrl;
    private String terminationDate;

    public PersonInputDTO(Person person) {
        this.person_id = person.getPerson_id();
        this.usr = person.getUsr();
        this.password = person.getPassword();
        this.surname = person.getSurname();
        this.name = person.getName();
        this.city = person.getCity();
        this.companyMail = person.getCompanyMail();
        this.personalMail = person.getPersonalMail();
        this.active = person.getActive();
        this.createdDate = person.getCreatedDate();
        this.imageUrl = person.getImageUrl();
        this.terminationDate = person.getTerminationDate();
    }

}
