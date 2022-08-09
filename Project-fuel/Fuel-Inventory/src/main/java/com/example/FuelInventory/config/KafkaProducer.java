package com.example.FuelInventory.config;

import com.example.FuelInventory.model.FuelOrder;
import com.example.FuelInventory.model.FuelReserved;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProducer {

    @Value("localhost:9092")
    private String boostrapServer;


    public Map<String, Object> producerConfig(){

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,boostrapServer);
        objectMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        objectMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return objectMap;
    }

    @Bean
    public ProducerFactory<String, FuelReserved> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, FuelReserved> kafkaTemplate (ProducerFactory<String, FuelReserved> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }
}
