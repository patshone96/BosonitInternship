package com.example.block7crudvalidation.student.infrastructure.dtos;


import com.example.block7crudvalidation.student.entity.Student;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOStudentSimple implements Serializable {

    private Student student;


    public String toString(){

        return  "{ \n" +
                "id_Student: "+ student.getStudent_id() + "\n" +
                "Branch: "+ student.getBranch() + "\n" +
                "HoursPerWeek: "+ student.getHoursPerWeek() + "\n" +
                "Branch: "+ student.getBranch() + "\n" +
                "id_Person: "+ student.getPerson().getPerson_id() + "\n" +
                "Use: "+ student.getPerson().getUsr() + "\n" +
                "Name: "+ student.getPerson().getName() + "\n" +
                "Surname: "+ student.getPerson().getSurname() + "\n" +
                "}";
    }



}
