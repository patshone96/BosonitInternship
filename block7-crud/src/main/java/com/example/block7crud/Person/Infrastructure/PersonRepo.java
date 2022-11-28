package com.example.block7crud.Person.Infrastructure;

import com.example.block7crud.Person.Domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

//Person repository that extends the CRUD repository, gaining access to a series of funtions to perform a CRUD
public interface PersonRepo extends CrudRepository<Person, Integer> {

    //We add this funtion that performs a Query that returns all entries for a given name.
    //Returns an empty list if there aren't entries with that name
    @Query("SELECT p FROM Person p WHERE p.name = :name")
    ArrayList<Person> findPersonByName(String name);

}
