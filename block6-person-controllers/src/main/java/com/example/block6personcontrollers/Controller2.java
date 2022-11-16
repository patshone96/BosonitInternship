package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("controller2")
public class Controller2 {

    @Autowired
    PersonService personService;

    @Autowired
    cityRepository cityRepo;


    // Get request that Returns the person added on the controller1 with their age doubled
    @GetMapping(value="/getPerson")
    public ResponseEntity<Person> getPerson(){
        personService.doubleAge();
        return ResponseEntity.ok().body(personService.getPerson());
    }


    // Get request that returns the cities stored on cityRepo. These are 4 when the program starts
    // But grow each time a POST request is accepted by the controller1
    @GetMapping(value="/getCity")
    public ResponseEntity<List<City>> getCity(){
        return ResponseEntity.ok().body(cityRepo.getCities());
    }

}
