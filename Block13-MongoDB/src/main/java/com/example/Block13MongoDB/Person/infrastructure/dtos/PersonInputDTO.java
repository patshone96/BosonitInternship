package com.example.Block13MongoDB.Person.infrastructure.dtos;

import com.example.Block13MongoDB.Person.model.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PersonInputDTO {

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


}
