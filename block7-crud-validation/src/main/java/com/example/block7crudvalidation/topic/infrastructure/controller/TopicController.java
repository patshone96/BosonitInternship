package com.example.block7crudvalidation.topic.infrastructure.controller;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.topic.entity.Topic;
import com.example.block7crudvalidation.topic.service.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    TopicServiceImpl topicService;

    @PostMapping("add")
    public Topic addTopic(@RequestBody Topic topic) throws UnprocessableEntityException {
        return topicService.addTopic(topic);
    }

    @GetMapping("get/{id}")
    public Topic getTopic(@PathVariable Integer id) throws EntityNotFoundException {
        return topicService.getTopic(id);
    }

    @GetMapping("getAll")
    public Iterable<Topic> getAll() {
        return topicService.getAll();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Integer id) throws EntityNotFoundException {
        topicService.deleteTopic(id);
        return ResponseEntity.ok().body(String.format("TOPIC WITH ID: %d DELETED", id));
    }



}