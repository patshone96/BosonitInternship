package com.example.Block10docker.Person.service;

import com.example.Block10docker.Exceptions.EntityNotFoundException;
import com.example.Block10docker.Person.model.Person;
import com.example.Block10docker.Person.infrastructure.repository.PersonRepo;
import com.example.Block10docker.Exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;


    @Override
    public Person getPerson(Integer id) throws EntityNotFoundException {

        if(personRepo.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }else{
            return (Person) personRepo.findById(id).get();
        }

    }

    @Override
    public Iterable<Person> getAll() {
        return personRepo.findAll();
    }

    @Override
    public Person addPerson(Person person) throws UnprocessableEntityException {

        return personRepo.save(person);

    }

    @Override
    public void deletePerson(Integer id) throws EntityNotFoundException {

        personRepo.deleteById(id);

    }
}
