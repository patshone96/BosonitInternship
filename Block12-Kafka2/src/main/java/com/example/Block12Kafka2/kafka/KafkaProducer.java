package com.example.Block12Kafka2.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;


@Service
public class KafkaProducer {

    //We can the Logger class to show the messages we are producing on the console
    //We can also use Sout();
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    //Instantiate the KafkaTemplate class, which will be used to send messages to a topic residing in kafka
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message){

        //We use the KafkaTemplate instance to send a message to the topic "bosonit1"
        kafkaTemplate.send("bosonit2", message);

        //LOGGER.info(String.format("Message sent %s", message));
        System.out.println(String.format("Message sent %s", message));
    }

}
