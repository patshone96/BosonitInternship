package com.example.Block10docker.Person.infrastructure.repository;

import com.example.Block10docker.Person.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.name = :name")
    ArrayList<Person> findPersonByName(String name);


}