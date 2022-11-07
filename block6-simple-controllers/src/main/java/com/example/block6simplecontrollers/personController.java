package com.example.block6simplecontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //We specify this class as a rest controller
public class personController {

    // Define the endpoint user/{name} where we greet the user using the variable {name}
    @GetMapping(value= {"user/{name}"})
    public String greeting(@PathVariable("name") String name){ //We store the name Path Variable
        return("Hi " + name + "!");
    }

    // If there is no resource after user, we just greet them with Hi!
    @GetMapping(value= {"user/"})
    public String greetingNull(){
        return("Hi!");

    }

    // Define the useradd endpoint, which takes data of a person (name, age, city) and as a confirmation
    // Returns the Person object with +1 age
    @PostMapping(value="useradd")
    public ResponseEntity<Person> posting(@RequestBody Person addPerson){
        addPerson.setAge(addPerson.getAge()+1); // +1 years to age
        return ResponseEntity.ok().body(addPerson);

    }

    // The data put in the body of the post request follows the JSON structure --> EXAMPLE
    //{
    //    "name": "Sofia",
    //    "age": 31,
    //    "city": "Sevilla"
    //}




}

