package com.example.FuelSchedule.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicDispatch {

    public static final String MESSAGE_TOPIC = "schedule_dispatch_topic";

    @Bean
    public NewTopic myTopicDispatch(){
        return TopicBuilder.name(MESSAGE_TOPIC)
                .build();
    }
}
