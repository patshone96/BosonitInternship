package com.example.Block13MongoDB.Person.infrastructure.controller;

import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonInputDTO;
import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonOutputDTO;
import com.example.Block13MongoDB.Person.service.PersonService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

@RestController
@RequestMapping
public class PersonCrontroller {

    @Autowired
    PersonService personService;


    //Save a person on the repository
    @PostMapping
    public PersonOutputDTO add(
            @RequestBody PersonInputDTO personInputDTO
            ){
        return personService.add(personInputDTO);
    }

    //Get a person by ID
    @GetMapping("{id}")
    public PersonOutputDTO get(
           @PathVariable Long id
    ) throws FileNotFoundException {
        return personService.get(id);
    }

    //Get all people stored on the DB
    @GetMapping("all")
    public ArrayList<PersonOutputDTO> getAll(
    ) throws FileNotFoundException {
        return (ArrayList<PersonOutputDTO>) personService.getAll();
    }


    //Handles responses when a FileNotFoundException is thrown
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //Code of the response
    public String unprocessableEntity(FileNotFoundException u){
        return u.getMessage(); //Show the message of the exception
    }
}
