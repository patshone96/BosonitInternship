package com.example.block7crud.person.infrastructure.repository;

import com.example.block7crud.person.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
//Person repository that extends the CRUD repository, gaining access to a series of funtions to perform a CRUD
public interface PersonRepo extends CrudRepository<Person, Integer> {

    //We add this funtion that performs a Query that returns all entries for a given name.
    //Returns an empty list if there aren't entries with that name
    @Query("SELECT p FROM Person p WHERE p.name = :name")
    ArrayList<Person> findPersonByName(String name);

}
