package com.example.block7crudvalidation.topic.service;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.topic.entity.Topic;
import org.springframework.stereotype.Service;

@Service
public interface TopicService {

    public Topic getTopic(Integer id) throws EntityNotFoundException;
    public Iterable<Topic> getAll();
    public Topic addTopic(Topic topic) throws UnprocessableEntityException;
    public void deleteTopic(Integer id);


}
