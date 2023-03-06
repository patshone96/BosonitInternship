package com.example.Block13MongoDB.Person.infrastructure.controller;

import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonInputDTO;
import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonOutputDTO;
import com.example.Block13MongoDB.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
