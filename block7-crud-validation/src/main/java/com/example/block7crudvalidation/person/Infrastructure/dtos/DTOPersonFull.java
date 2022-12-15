package com.example.block7crudvalidation.person.Infrastructure.dtos;

import com.example.block7crudvalidation.person.entity.Person;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DTOPersonFull {
    private Person person;

    public String toString(){

        return "{" +
                "id_person: "  + person.getPerson_id()  + "\n" +
                "Name: "  + person.getName()  + "\n" +
                "Surname: "  + person.getSurname()  + "\n" +
                "Usr: "  + person.getUsr()  + "\n" +
                "City: "  + person.getCity()  + "\n" +
                "Active: "  + person.getActive()  + "\n" +
                "PersonalMail: "  + person.getPersonalMail()  + "\n" +
                "CompanyMail: "  + person.getCompanyMail()  + "\n" +
                "CreatedDate: "  + person.getCreatedDate()  + "\n" +
                "TerminationDate: "  + person.getTerminationDate()  + "\n" +
                "ImageURL: "  + person.getImageUrl()  + "\n" +
                "}";

    }
}
