package com.example.block7crudvalidation.person.infrastructure.dtos;

import com.example.block7crudvalidation.person.entity.Person;

public class PersonOutputDTOSimple extends PersonDTOs{

    private Integer person_id;
    private String usr;
    private String name;
    private String surname;
    private String city;
    private String companyMail;

    public PersonOutputDTOSimple(Person person) {
        this.person_id = person.getPerson_id();
        this.usr = person.getUsr();
        this.name = person.getName();
        this.city = person.getCity();
        this.companyMail = person.getCompanyMail();

    }

    @Override
    public String toString() {
        return "person_id: " + person_id + ", \n" +
                "user: " + usr + ", \n" +
                "name: " + name + ", \n" +
                "city: " + city + ", \n" +
                "companyEmail: " + companyMail + ", \n";


    }
}
