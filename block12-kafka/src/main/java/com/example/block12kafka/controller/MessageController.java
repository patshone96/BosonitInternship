package com.example.block12kafka.controller;

import com.example.block12kafka.kafka.KafkaProducer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;



//    public MessageController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }


    // http:localhost:8080/publish?message=...
    @GetMapping("publish")
    public ResponseEntity<String> publish(@RequestParam("message") String messsage){
        kafkaProducer.sendMessage(messsage);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
