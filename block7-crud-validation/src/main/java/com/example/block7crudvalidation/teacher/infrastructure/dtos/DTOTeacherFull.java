package com.example.block7crudvalidation.teacher.infrastructure.dtos;

import com.example.block7crudvalidation.teacher.entity.Teacher;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOTeacherFull implements Serializable {

    private Teacher teacher;

    public String toString(){

        return "{ \n" +
                "id_Teacher: "+ teacher.getTeacher_id() + "\n" +
                "Branch: "+ teacher.getBranch() + "\n" +
                "Comments: "+ teacher.getComments() + "\n" +
                "id_Person: "+ teacher.getPerson().getPerson_id() + "\n" +
                "Name: "+ teacher.getPerson().getName() + "\n" +
                "Surname: "+ teacher.getPerson().getSurname() + "\n" +
                "Usr: "+ teacher.getPerson().getUsr() + "\n" +
                "City: "+ teacher.getPerson().getCity() + "\n" +
                "Active: "+ teacher.getPerson().getActive() + "\n" +
                "Students: " + teacher.getStudents().toString() + "\n" +
                "PersonaMail: "+ teacher.getPerson().getPersonalMail()+ "\n" +
                "CompanyMail: "+ teacher.getPerson().getCompanyMail() + "\n" +
                "CreatedDate: "+ teacher.getPerson().getCreatedDate() + "\n" +
                "TerminationDate: "+ teacher.getPerson().getTerminationDate() + "\n" +
                "ImageURL: "+ teacher.getPerson().getImageUrl() + "\n" +
                "}";

    }

}
