package com.example.block7crud.Person.Application;

import com.example.block7crud.Person.Domain.Person;
import com.example.block7crud.Person.Infrastructure.EmptyFieldsException;
import com.example.block7crud.Person.Infrastructure.PersonRepo;
import com.example.block7crud.Person.Infrastructure.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

// Here we develop the methods of the PersonService interface. This is genrally easy thanks to the PersonRepo class
// Which extends the Crud repo, and its methods to perform a CRUD
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Override
    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person modifyPerson(Person person, Integer id) throws PersonNotFoundException, EmptyFieldsException {

        Optional<Person> op = personRepo.findById(id); //We look for a person on the repository

        if (op.isPresent()){ //If the person exists...

            Person pers = op.get(); //We retrieve the data of said person

            //Check for the data provided to modify a person
            //If any field is empty, we throw an exception
            if(person.getName().length() == 0 || person.getName() == null ||
                    person.getSurname().length() == 0 || person.getSurname() == null ||
                    person.getCity().length() == 0 || person.getCity() == null){

                throw new EmptyFieldsException("Cannot be any empty fields or null values");

            }

            //We change the person's data to the provided one

            pers.setName(person.getName());
            pers.setSurname(person.getSurname());
            pers.setCity(person.getCity());

            //We return the modified person
            return personRepo.save(pers);
        }else{ //If the person to change does not exist on the repo we throw an exception
            throw new PersonNotFoundException("The id provided does not exist on the repo");
        }

    }

    @Override
    public void deletePerson(int id) {
       personRepo.deleteById(id);
    }

    @Override
    public Person getPerson(int id) throws PersonNotFoundException {
        //If the person we look for does not exist, a PersonNotFoundException is thrown
        return personRepo.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found"));
    }

    @Override
    //Because more than one person may have the same name, we return a list of people with said name
    //The list may be empty if there is no person with the provided name
    public ArrayList<Person> getPerson(String name) {
        return personRepo.findPersonByName(name);
    }

    @Override
    //We get an Iterable object with all the people on the repo
    public Iterable<Person> getAll() {
        return personRepo.findAll();
    }
}
