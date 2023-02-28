package com.example.block7crudvalidation.person.service;

import com.example.block7crudvalidation.person.infrastructure.dtos.PersonInputDTO;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonOutputDTOFull;
import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public interface PersonService{

    public Person getPerson(Integer id) throws EntityNotFoundException;
    public ArrayList<Person> getUser(String user) throws EntityNotFoundException;
    public ArrayList<PersonOutputDTOFull> getAll();
    public PersonOutputDTOFull addPerson(PersonInputDTO PersonDTO) throws UnprocessableEntityException;
    public void deletePerson(Integer id) throws EntityNotFoundException;

    public List<Person> getCustomQuery(HashMap<String, Object> map);
    

}
