package com.example.Block13MongoDB.Person.service;

import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonInputDTO;
import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonOutputDTO;
import com.example.Block13MongoDB.Person.infrastructure.repository.PersonRepository;
import com.example.Block13MongoDB.Person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceInterface implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDTO add(PersonInputDTO personInputDTO) {

        //Convert the InputDTO into a person, save it and then return an output DTO of the person.

        return new PersonOutputDTO(
                personRepository.save(
                        personInputDTO
                                .toPerson()
                ));
    }

    @Override
    public PersonOutputDTO get(Long id) throws FileNotFoundException {

        //Try to retrieve the person
        Optional<Person> op = personRepository.findById(id);

        //If no person is found, an Exception is thrown
        if(op.isEmpty()){
            throw new FileNotFoundException("Person not found");
        }

        //If there is a person with the provided id, we return an OutputDTO
        return new PersonOutputDTO(op.get());
    }

    @Override
    public ArrayList<PersonOutputDTO> getAll() {

        //We'll return a list of people
        ArrayList<PersonOutputDTO> people = new ArrayList<>();

        //Ask for a list of people to the repository, cast each person to an output DTO and adding them to the list
        personRepository.findAll().stream().forEach(p -> people.add(new PersonOutputDTO(p)));

        //Return the outputDTOs
        return people;
    }

    @Override
    public String delete(long id) {
        return null;
    }

    @Override
    public PersonOutputDTO modify(long id) {
        return null;
    }
}
