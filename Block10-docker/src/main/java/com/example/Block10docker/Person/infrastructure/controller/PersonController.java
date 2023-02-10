package com.example.Block10docker.Person.infrastructure.controller;


import com.example.Block10docker.Exceptions.EntityNotFoundException;
import com.example.Block10docker.Exceptions.UnprocessableEntityException;
import com.example.Block10docker.Person.model.Person;
import com.example.Block10docker.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id) throws EntityNotFoundException {
        return personService.getPerson(id);
    }


    @GetMapping()
    public Iterable<Person> getAll() throws EntityNotFoundException {
        return personService.getAll();
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) throws UnprocessableEntityException {
        return personService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Integer id) throws EntityNotFoundException {
        personService.deletePerson(id);
    }


    //Handling exceptions

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



