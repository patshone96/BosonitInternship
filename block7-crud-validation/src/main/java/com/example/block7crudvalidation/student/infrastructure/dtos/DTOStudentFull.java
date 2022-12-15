package com.example.block7crudvalidation.student.infrastructure.dtos;

import com.example.block7crudvalidation.student.entity.Student;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOStudentFull implements Serializable {

    private Student student;
    
    public String toString(){

        
        return "{ \n" +
                "id_Student: "+ student.getStudent_id() + "\n" +
                "Branch: "+ student.getBranch() + "\n" +
                "HoursPerWeek: "+ student.getHoursPerWeek() + "\n" +
                "Branch: "+ student.getBranch() + "\n" +
                "id_Person: "+ student.getPerson().getPerson_id() + "\n" +
                "Use: "+ student.getPerson().getUsr() + "\n" +
                "Name: "+ student.getPerson().getName() + "\n" +
                "Surname: "+ student.getPerson().getSurname() + "\n" +
                "City: "+ student.getPerson().getCity() + "\n" +
                "PersonaMail: "+ student.getPerson().getPersonalMail() + "\n" +
                "Active: "+ student.getPerson().getActive() + "\n" +
                "CompanyMail: "+ student.getPerson().getCompanyMail() + "\n" +
                "CreatedDate: "+ student.getPerson().getCreatedDate() + "\n" +
                "TerminationDate: "+ student.getPerson().getTerminationDate() + "\n" +
                "id_Teacher: "+ student.getTeacher().getTeacher_id() + "\n"+
                "TeacherName: "+ student.getTeacher().getPerson().getName() + "\n"+
                "TeacherSurname: "+ student.getTeacher().getPerson().getSurname() + "\n"+
                "TeacherMail: "+ student.getTeacher().getPerson().getCompanyMail() + "\n"+
                "TeacherBranch: "+ student.getTeacher().getBranch() + "\n"+
                "TeacherComments: "+ student.getTeacher().getComments() + "\n"+
                        "}";

    };
    }



