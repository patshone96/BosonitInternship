package com.example.Block12Kafka2.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

//Creates a kafaka topic to which we send the messages using the kafka producer when the consumer receives a message
@Configuration
public class KafkaTopicConfig {

    //This bean uses the NewTopic class and the TopicBuilder class to create the kafka class
    //The final method has to be the .build() one.
    @Bean
    public NewTopic bosonitTopic(){
        return TopicBuilder.name("bosonit2")
                .build();
    }


}
