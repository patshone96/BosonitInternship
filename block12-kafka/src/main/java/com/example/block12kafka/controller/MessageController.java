package com.example.block12kafka.controller;

import com.example.block12kafka.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    //We instantiate a KafkaProducer that will post messages on Kafka
    @Autowired
    private KafkaProducer kafkaProducer;


    //This get method reads the "message" parameter on the endpoint and sends its content to
    // a kafka topic through the kafkaProducer instance. Then returns a message to the client
    // Showing that everything has worked fine
    // http:localhost:8080/publish?message=...
    @GetMapping("publish")
    public ResponseEntity<String> publish(@RequestParam("message") String messsage){
        kafkaProducer.sendMessage(messsage);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
