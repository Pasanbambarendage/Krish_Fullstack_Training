package com.example.FuelSchedule.listener;

import com.example.FuelInventory.model.FuelReserved;
import com.example.FuelSchedule.service.FuelScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Kafkalistener {

    @Autowired
    FuelScheduleService fuelScheduleService;

    @KafkaListener(topics = "inventory_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<FuelReserved> list){

        String value = String.valueOf(list);
        int orderId =0;

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<FuelReserved> fuelReserved = objectMapper.readValue(value, new TypeReference<List<FuelReserved>>() {});

            for(FuelReserved reserved : fuelReserved){
                orderId = reserved.getOrderId();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println (fuelScheduleService.deliverDate (orderId));

    }
}
