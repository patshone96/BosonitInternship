package com.example.block12kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.Format;


@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "bosonit", groupId = "miGrupo")
    public void consume(String message){

        LOGGER.info(String.format("Message received -> %s", message));


    }

}
