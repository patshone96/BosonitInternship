package com.example.block7crudvalidation.topic.service;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.topic.entity.Topic;
import com.example.block7crudvalidation.topic.infrastructure.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepo topicRepo;


    @Override
    public Topic getTopic(Integer id) throws EntityNotFoundException {
         Optional<Topic> op = topicRepo.findById(id);

         if (op.isEmpty()){
             throw new EntityNotFoundException();
         }else{
             return op.get();
         }
    }

    @Override
    public Iterable<Topic> getAll() {
        return topicRepo.findAll();
    }

    @Override
    public Topic addTopic(Topic topic) throws UnprocessableEntityException {
        return topicRepo.save(topic);
    }

    @Override
    public void deleteTopic(Integer id) throws EntityNotFoundException {
        if(topicRepo.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }else{
            topicRepo.deleteById(id);
        }
    }
}
