package com.example.block7crudvalidation.person.service;

import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PersonService{

    public Person getPerson(Integer id) throws EntityNotFoundException;
    public ArrayList<Person> getUser(String user) throws EntityNotFoundException;
    public Iterable<Person> getAll();
    public Person addPerson(Person person) throws UnprocessableEntityException;

    public void deletePerson(Integer id) throws EntityNotFoundException;

}
