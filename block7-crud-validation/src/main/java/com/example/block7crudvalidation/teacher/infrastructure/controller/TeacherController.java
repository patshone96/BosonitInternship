package com.example.block7crudvalidation.teacher.infrastructure.controller;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.person.service.PersonService;
import com.example.block7crudvalidation.teacher.infrastructure.dtos.DTOTeacherFull;
import com.example.block7crudvalidation.teacher.infrastructure.dtos.DTOTeacherSimple;
import com.example.block7crudvalidation.teacher.entity.Teacher;
import com.example.block7crudvalidation.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    PersonService personService;

    @PostMapping("add/{id}")
    public Teacher addTeacher(@RequestBody Teacher teacher,
                              @PathVariable Integer id) throws EntityNotFoundException, UnprocessableEntityException {

        teacher.setPerson(personService.getPerson(id));

        return teacherService.addTeacher(teacher);

    }

    @GetMapping("get/{id}")
    //If the ID does not exist in the REPO, a PersonNotFoundException will be thrown
    public DTOTeacherFull getTeacherByID(@PathVariable Integer id, @RequestParam(defaultValue = "simple") String outputType) throws EntityNotFoundException{

        if(outputType.equals("full")){
            DTOTeacherFull full = new DTOTeacherFull( teacherService.getTeacher(id));
            return full;
            //return full.toString();

        }else{
            DTOTeacherFull full = new DTOTeacherFull( teacherService.getTeacher(id));
            return full;
            //DTOTeacherSimple simple = new DTOTeacherSimple( teacherService.getTeacher(id));
            //return simple.toString();

        }

    }

    @GetMapping("getAll")
    public Iterable<Teacher> getAll(){
        return teacherService.getAll();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Integer id) throws EntityNotFoundException {

        try{ //If the ID exists
            teacherService.deleteTeacher(id);
            return ResponseEntity.ok().body(String.format( "STUDENT WITH ID: %d DELETED", id));

        }catch(Exception e){ //If the ID does not exist we throw an exception
            throw new EntityNotFoundException();

        }


    }

    //Handles responses when EntityNotFoundException is thrown
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //Code of the response
    public String entityNotFound(EntityNotFoundException e){
        return e.getMessage(); //Show the message of the exception

    }

    //Handles responses when UnprocessableEntityException is thrown
    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //Code of the response
    public String unprocessableEntity(UnprocessableEntityException u){
        return u.getMessage(); //Show the message of the exception
    }
}
