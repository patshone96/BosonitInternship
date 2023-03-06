package com.example.Block13MongoDB.Person.infrastructure.dtos;

import com.example.Block13MongoDB.Person.model.Person;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO implements Serializable {

     long id;
     String usr;
     String password;
     String name;
     String surname;
     String city;
     String companyMail;
     String personalMail;
     Boolean active;
     Date createdDate;
     String imageUrl;
     Date terminationDate;

     public PersonInputDTO(Person person){

         this.id = person.getId();
         this.usr = person.getUsr();
         this.password = person.getPassword();
         this.name = person.getName();
         this.surname = person.getSurname();
         this.city = person.getCity();
         this.companyMail = person.getCompanyMail();
         this.personalMail = person.getPersonalMail();
         this.active = person.getActive();
         this.createdDate = getCreatedDate();
         this.imageUrl = person.getImageUrl();
         this.terminationDate = person.getTerminationDate();

     }

    public Person toPerson(){

         Person person = new Person();

         person.setId(this.id);
         person.setUsr(this.usr);
         person.setPassword(this.password);

         person.setName(this.name);
        person.setSurname(this.surname);
        person.setCity(this.city);

        person.setCompanyMail(this.companyMail);
        person.setPersonalMail(this.personalMail);
        person.setActive(this.active);

        person.setCreatedDate(this.createdDate);
        person.setImageUrl(this.imageUrl);
        person.setTerminationDate(this.terminationDate);

        return person;

    }


}
