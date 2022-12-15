package com.example.block7crudvalidation.topic.infrastructure.controller;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.topic.entity.Topic;
import com.example.block7crudvalidation.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    TopicService topicService;

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



}