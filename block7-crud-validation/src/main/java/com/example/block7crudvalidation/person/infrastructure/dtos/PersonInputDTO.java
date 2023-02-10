package com.example.block7crudvalidation.person.infrastructure.dtos;

import com.example.block7crudvalidation.person.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO {

    private Integer person_id;

    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String city;

    private String company_email;

    private String personal_email;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public PersonInputDTO(Person person) {
        this.person_id = person.getPerson_id();
        this.usuario = person.getUsr();
        this.password = person.getPassword();
        this.surname = person.getSurname();
        this.name = person.getName();
        this.city = person.getCity();
        this.company_email = person.getCompanyMail();
        this.personal_email = person.getPersonalMail();
        this.active = person.getActive();
        this.created_date = person.getCreatedDate();
        this.imagen_url = person.getImageUrl();
        this.termination_date = person.getTerminationDate();
    }

}
