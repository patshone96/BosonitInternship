package com.example.Block13MongoDB.Person.infrastructure.repository;

import com.example.Block13MongoDB.Person.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, Long> {
}
