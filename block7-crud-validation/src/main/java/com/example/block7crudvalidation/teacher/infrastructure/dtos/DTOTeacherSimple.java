package com.example.block7crudvalidation.teacher.infrastructure.dtos;

import com.example.block7crudvalidation.teacher.entity.Teacher;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOTeacherSimple {

    private Teacher teacher;

    public String toString(){

        return "{ \n" +
                "id_Teacher: "+ teacher.getTeacher_id() + "\n" +
                "Branch: "+ teacher.getBranch() + "\n" +
                "Comments: "+ teacher.getComments() + "\n" +
                "id_Person: "+ teacher.getPerson().getPerson_id() + "\n" +
                "Name: "+ teacher.getPerson().getName() + "\n" +
                "Surname: "+ teacher.getPerson().getSurname() + "\n" +
                "}";

    }
}
