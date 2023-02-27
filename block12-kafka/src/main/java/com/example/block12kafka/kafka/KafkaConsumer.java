package com.example.block12kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {

    //This consumer will read messages posted on the topic bosonit2. This topic is created on
    // The second kafka app and is this second app which sends messages to this topic

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    //We use the annotation KafkaListener so the app monitors the topic bosonit2 waiting for a message
    // To be posted there
    @KafkaListener(topics = "bosonit2", groupId = "Grupo1")
    public void consume(String message){

        //LOGGER.info(String.format("Message received -> %s", message));
        System.out.println(String.format("Message received -> %s", message));


    }

}
