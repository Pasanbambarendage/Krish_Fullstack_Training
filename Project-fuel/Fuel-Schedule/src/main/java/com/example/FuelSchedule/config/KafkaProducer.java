package com.example.FuelSchedule.config;

import com.example.FuelSchedule.model.FuelSchedule;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducer {

    @Value("localhost:9092")
    private String boostrapServer;

    public Map<String,Object> configProducer(){
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServer);
        orderMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        orderMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return orderMap;
    }

    @Bean
    public ProducerFactory<String, FuelSchedule> producerFactory(){
        return new DefaultKafkaProducerFactory<>(configProducer());
    }

    @Bean
    public KafkaTemplate<String, FuelSchedule> kafkaTemplate(ProducerFactory<String, FuelSchedule> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }
}
