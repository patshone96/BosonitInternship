package com.example.block12kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic bosonitTopic(){
        return TopicBuilder.name("bosonit")
                //.partitions(10)
                .build();
    }

}
