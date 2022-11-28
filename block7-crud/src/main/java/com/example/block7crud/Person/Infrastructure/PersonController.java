package com.example.block7crud.Person.Infrastructure;


import com.example.block7crud.Person.Domain.Person;
import com.example.block7crud.Person.Application.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/person") //All requests must contain /person to access the controller
public class PersonController {

    @Autowired
    PersonService personService;

    //Post mapping of a person:
    //{
    //"name":"Maria",
    //"surname":"Castro",
    //"city": "Valencia"
    //}
    @PostMapping("add")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);

    }

    //Remove a person from the REPO by ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Integer id){

        try{ //If the ID exists
            personService.deletePerson(id);
            return ResponseEntity.ok().body(String.format( "PERSON WITH ID: %d DELETED", id));

        }catch(Exception e){ //If the ID does not exist we throw an exeption
            throw new PersonNotFoundException("Person not found");

        }




    }

    @GetMapping("get/{id}")
    //If the ID does not exist in the REPO, a PersonNotFoundException will be thrown
    public Person getPersonById(@PathVariable Integer id) throws PersonNotFoundException{

        return personService.getPerson(id);

    }


    @GetMapping("get/name/{name}")
    public ArrayList<Person> getPersonByName(@PathVariable String name) throws PersonNotFoundException{

        //If there is no person with the given name, a PersonNotFoundExcception is thrown,
        // else a list of persons is returned
        if(personService.getPerson(name).isEmpty()){throw new PersonNotFoundException("Person not found");};

        return personService.getPerson(name);

    }

    @GetMapping("getAll")
    //Returns an Iterable object with containing all the people on the Repo
    public Iterable<Person> getAll(){

        return personService.getAll();

    }



    @PutMapping("change/{id}")
    //Tries to change an entry. If the entry (id) does not exist, this throws a PersonNotFoundException
    //If there is any empty field, a EmptyFieldException is thrown
    public Person changePerson(@RequestBody Person person,
                               @PathVariable Integer id) throws PersonNotFoundException, EmptyFieldsException {

        return personService.modifyPerson(person, id);

    }



    //This method handles PersonNotFoundException returning a 404 code
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<String> personNotFound(){
        return ResponseEntity.notFound().build();


    }

    //This method hadled EmptyFieldException returning a BadRequest code
    @ExceptionHandler(EmptyFieldsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> emptyFields(){
        return ResponseEntity.badRequest().build();


    }


}
