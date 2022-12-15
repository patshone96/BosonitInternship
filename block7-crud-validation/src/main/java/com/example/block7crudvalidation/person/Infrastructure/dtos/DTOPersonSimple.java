package com.example.block7crudvalidation.person.Infrastructure.dtos;

import com.example.block7crudvalidation.person.entity.Person;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DTOPersonSimple {

    private Person person;

    public String toString(){

        return "{" +
                "id_person: "  + person.getPerson_id()  + "\n" +
                "Name: "  + person.getName()  + "\n" +
                "Surname: "  + person.getSurname()  + "\n" +
                "Usr: "  + person.getUsr()  + "\n" +
                "}";

    }
}
