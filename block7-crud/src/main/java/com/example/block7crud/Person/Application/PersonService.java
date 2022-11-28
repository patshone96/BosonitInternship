package com.example.block7crud.Person.Application;

import com.example.block7crud.Person.Domain.Person;
import com.example.block7crud.Person.Infrastructure.EmptyFieldsException;
import com.example.block7crud.Person.Infrastructure.PersonNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Interface that defines the methods to implement on the Person Service Implementation class
@Service
public interface PersonService {

    public Person addPerson(Person person);
    public Person modifyPerson(Person person, Integer id) throws PersonNotFoundException, EmptyFieldsException;
    public void deletePerson(int id);
    public Person getPerson(int id) throws PersonNotFoundException;
    public ArrayList<Person> getPerson(String name);
    public Iterable<Person> getAll();

}
