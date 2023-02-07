package com.example.block7crudvalidation.person.infrastructure.repository;

import com.example.block7crudvalidation.person.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PersonRepo extends CrudRepository<Person, Integer> {

    //Custom query to retrieve all people from the repository by user(name) and return it as an ArrayList
    @Query("SELECT p FROM Person p WHERE p.usr = :usr")
    ArrayList<Person> findPersonByName(String usr);



}
