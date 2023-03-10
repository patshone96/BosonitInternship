package com.example.block7crudvalidation.person.infrastructure.dtos;

import com.example.block7crudvalidation.person.entity.Person;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class PersonOutputDTOFull extends PersonDTOs{

    private Integer person_id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String city;
    private Boolean active;
    private String company_email;
    private String personal_email;

    private String created_date;

    private String imagen_url;
    private String termination_date;



    public PersonOutputDTOFull(Person person) {

        //Formateador de fecha
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");


        this.person_id = person.getPerson_id();
        this.usuario = person.getUsr();
        this.name = person.getName();
        this.password = person.getPassword();
        this.surname = person.getSurname();
        this.city = person.getCity();
        this.company_email = person.getCompanyMail();
        this.personal_email = person.getPersonalMail();
        this.active = person.getActive();
        this.created_date = DateFor.format(person.getCreatedDate());;
        this.imagen_url = person.getImageUrl();
        this.termination_date = DateFor.format(person.getTerminationDate());
    }

    @Override
    public String toString() {
        return "person_id: " + person_id + ", \n" +
                 "user: " + usuario + ", \n" +
                 "name: " + name + ", \n" +
                "surname: " + surname + ", \n" +
                 "city: " + city + ", \n" +
                 "companyEmail: " + company_email + ", \n" +
                 "personalMail: " + personal_email + ", \n" +
                 "active: " + active + ", \n" +
                 "createdDate: " + created_date + ", \n" +
                 "imageUrl: " + imagen_url + ", \n" +
                 "terminationDate: " + termination_date + ", \n";

    }
}
