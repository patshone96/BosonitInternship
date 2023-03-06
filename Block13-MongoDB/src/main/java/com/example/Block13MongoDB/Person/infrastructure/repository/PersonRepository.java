package com.example.Block13MongoDB.Person.infrastructure.repository;

import com.example.Block13MongoDB.Person.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, Long> {
}
