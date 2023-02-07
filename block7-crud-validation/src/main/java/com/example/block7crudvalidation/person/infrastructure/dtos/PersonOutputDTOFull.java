package com.example.block7crudvalidation.person.infrastructure.dtos;

import com.example.block7crudvalidation.person.entity.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonOutputDTOFull {

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

    public PersonOutputDTOFull(Person person) {
        this.person_id = person.getPerson_id();
        this.usr = person.getUsr();
        this.name = person.getName();
        this.password = person.getPassword();
        this.surname = person.getSurname();
        this.city = person.getCity();
        this.companyMail = person.getCompanyMail();
        this.personalMail = person.getPersonalMail();
        this.active = person.getActive();
        this.createdDate = person.getCreatedDate();
        this.imageUrl = person.getImageUrl();
        this.terminationDate = person.getTerminationDate();
    }

    @Override
    public String toString() {
        return "person_id: " + person_id + ", \n" +
                 "user: " + usr + ", \n" +
                 "name: " + name + ", \n" +
                "surname: " + surname + ", \n" +
                 "city: " + city + ", \n" +
                 "companyEmail: " + companyMail + ", \n" +
                 "personalMail: " + personalMail + ", \n" +
                 "active: " + active + ", \n" +
                 "createdDate: " + createdDate + ", \n" +
                 "imageUrl: " + imageUrl + ", \n" +
                 "terminationDate: " + terminationDate + ", \n";

    }
}
