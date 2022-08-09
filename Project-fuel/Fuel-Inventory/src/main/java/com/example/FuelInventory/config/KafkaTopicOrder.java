package com.example.FuelInventory.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaTopicOrder {

    public static final String MESSAGE_TOPIC = "inventory_order_topic";

    @Bean
    public NewTopic myTopic(){
        return TopicBuilder.name(MESSAGE_TOPIC)
                .build();
    }
}
