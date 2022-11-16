package com.example.block6personcontrollers;

import org.springframework.stereotype.Service;

// Contains the functions associated to the Person class. Double their age and return a Person;
@Service
public class PersonService {

    private Person person;
    private String name = null, city = null;
    private int age  = 0;

    public Person createPerson(String name){

        person = new Person(name, this.city, this.age);

        return person;

    }

    public Person createPerson(String name, String city, int age){

        person = new Person(name, city, age);

        return person;

    }

    public void doubleAge(){
        person.setAge(person.getAge() * 2);
    }

    public Person getPerson(){
        return person;
    }




}
