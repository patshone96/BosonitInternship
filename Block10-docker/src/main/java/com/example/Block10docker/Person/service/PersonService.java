package com.example.Block10docker.Person.service;

import com.example.Block10docker.Exceptions.EntityNotFoundException;
import com.example.Block10docker.Person.model.Person;
import com.example.Block10docker.Exceptions.UnprocessableEntityException;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    public Person getPerson(Integer id) throws EntityNotFoundException;
    public Iterable<Person> getAll();
    public Person addPerson(Person person) throws UnprocessableEntityException;
    public void deletePerson(Integer id) throws EntityNotFoundException;


}
