package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping(value="controller1")
public class Controller1 {

    @Autowired
    PersonService personService;

    @Autowired
    cityRepository cityRepo;

    //We generate a GET controller that takes three headers (name, city and age) and instantiates an object Person (p)
    // Through the PersonService class. Then, as a response, p is returned

    @GetMapping(value="/adduser")
    public ResponseEntity<Person> createUser(@RequestHeader("name") String name, //This annotation returns a header
                                             @RequestHeader("city") String city, // And we can store it on a variable
                                             @RequestHeader("age") int age)
    {

        Person p = personService.createPerson(name, city, age);

        return ResponseEntity.ok().body(p);
    }

    // POST Request to add a city to the cityRepository, returns the city added as a response
    // The request body has to follow the structure:
    // {
    //      "name": cityName
    //      "population": integer_city_population
    // }
    @PostMapping(value="/addCity")
    public ResponseEntity<City> addCity(@RequestBody City city){
        cityRepo.addCity(city);
        return ResponseEntity.ok().body(city);

    }


}
