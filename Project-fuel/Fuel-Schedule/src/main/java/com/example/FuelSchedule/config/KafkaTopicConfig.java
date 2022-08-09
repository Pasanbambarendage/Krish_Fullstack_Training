package com.example.FuelSchedule.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String MESSAGE_TOPIC ="schedule_topic";

    public NewTopic topic(){
        return TopicBuilder.name(MESSAGE_TOPIC).build();
    }
}