package com.example.block7crudvalidation.person.service;

import com.example.block7crudvalidation.person.Infrastructure.dtos.PersonInputDTO;
import com.example.block7crudvalidation.person.Infrastructure.dtos.PersonOutputDTOFull;
import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PersonService{

    public Person getPerson(Integer id) throws EntityNotFoundException;
    public ArrayList<Person> getUser(String user) throws EntityNotFoundException;
    public Iterable<Person> getAll();
    public PersonOutputDTOFull addPerson(PersonInputDTO PersonDTO) throws UnprocessableEntityException;
    public void deletePerson(Integer id) throws EntityNotFoundException;
    

}
