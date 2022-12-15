package com.example.block7crudvalidation.topic.infrastructure.repository;

import com.example.block7crudvalidation.topic.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepo extends CrudRepository<Topic, Integer> {
}
