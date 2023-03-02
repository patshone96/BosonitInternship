package com.example.Block12Kafka2.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class KafkaConsumer {


    //Array of messages to return and a Random class instantiation to be able to return a random answer
    String[] answers = {"Received", "Okay", "All good", "Got it!"};
    Random random = new Random();

    //Instantiate a KafkaProducer to send messages to kafka when a message is consumed
    @Autowired
    private KafkaProducer kafkaProducer;


    //private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

//    Listen to the bosonit1 kafka topic
    @KafkaListener(topics = "bosonit1", groupId = "Grupo1")
    public void consume(String message) throws InterruptedException {

        //LOGGER.info(String.format("Message received -> %s", message));

        //Print the message recieved
        System.out.println((String.format("Message received -> %s", message)));

        //We send a random message to kafka, this time to the topic2 (in topic config class)
        //which will be read by the  app1
        kafkaProducer.sendMessage(answers[random.nextInt(4)]);


    }



}