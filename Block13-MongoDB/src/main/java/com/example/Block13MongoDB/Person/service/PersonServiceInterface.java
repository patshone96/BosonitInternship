package com.example.Block13MongoDB.Person.service;

import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonInputDTO;
import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonOutputDTO;
import com.example.Block13MongoDB.Person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PersonOutputDTO get(Long id) {
        return null;
    }

    @Override
    public List<PersonOutputDTO> getAll() {
        return null;
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
