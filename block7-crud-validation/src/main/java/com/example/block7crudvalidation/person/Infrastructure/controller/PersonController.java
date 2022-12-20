package com.example.block7crudvalidation.person.Infrastructure.controller;
import com.example.block7crudvalidation.person.Infrastructure.dtos.DTOPersonFull;
import com.example.block7crudvalidation.person.Infrastructure.dtos.DTOPersonSimple;
import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.person.service.PersonService;
import com.example.block7crudvalidation.teacher.infrastructure.dtos.DTOTeacherFull;
import com.example.block7crudvalidation.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
//To use any oth the methods, we have to add /person to the path
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    TeacherService teacherService;

    //FEIGN
    //Request to the 8081 server for a teacher. This can be done from another port, e.g. 8080, prepared on run config
    @GetMapping("teacher/{id}")
    public String getTeacherFeign(@PathVariable Integer id) throws EntityNotFoundException {
        DTOTeacherFull full = new DTOTeacherFull(teacherService.getTeacher(id));
        return full.toString();

    }

    //Request to a server on another port using restTemplate and Response Entity
//    @GetMapping("/teacher/{id}")
//    public DTOTeacherFull getProfesor(@PathVariable Integer id) throws EntityNotFoundException{
//       ResponseEntity<DTOTeacherFull> full = new RestTemplate().getForEntity("http://localhost:8081/teacher/wideGet/1", DTOTeacherFull.class);
//       if(full.getStatusCode() == HttpStatus.OK){
//           return full.getBody();
//       }else{
//           return null;
//       }
//
//
//    }


    //POST mapping using /add
    @PostMapping("add")
    //We cast the body of the request and turn it into a Person instance. Then save it using the method addPerson from personServide
    public Person addPerson(@RequestBody Person person) throws UnprocessableEntityException {
        return personService.addPerson(person);
    }

    //GET mapping using /get/person_id
    @GetMapping("get/{id}")
    //Retrieve the value of the path variable, cast it as an integer and use it to get a person from the repository
    public String getById(@PathVariable Integer id,
                          @RequestParam(defaultValue = "simple") String outputType) throws EntityNotFoundException {



        if(outputType.equals("full")){
             DTOPersonFull full = new DTOPersonFull(personService.getPerson(id));
             return full.toString();

        }
        DTOPersonSimple simple = new DTOPersonSimple(personService.getPerson(id));
        return simple.toString();
    }

    //GET mapping using /getAll
    @GetMapping("/getAll")
    //Return an Iterable<Person> with all the people on the repository
    public Iterable<Person> getAll(){
        return personService.getAll();
    }

    //GET mapping using /user/user_id
    @GetMapping("/user/{user}")
    //Return an ArrayList with all people with the same user stored on the repository
    public ArrayList<Person> byUser(@PathVariable String user) throws EntityNotFoundException{

        return personService.getUser(user);

    }

    //DELETE mapping of a person by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Integer id) throws EntityNotFoundException {
        personService.deletePerson(id);
        return ResponseEntity.ok().body(String.format("PERSON WITH ID: %d DELETED", id));
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
