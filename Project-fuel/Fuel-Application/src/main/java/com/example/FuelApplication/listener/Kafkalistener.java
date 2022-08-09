package com.example.FuelApplication.listener;

import com.example.FuelApplication.service.FuelOrderService;
import com.example.FuelInventory.model.FuelReserved;
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
    FuelOrderService fuelOrderService;

    @KafkaListener(topics = "inventory_order_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<FuelReserved> list){

        String value = String.valueOf(list);
        int orderId =0;
        String fuleStatus ="Allocated";

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<FuelReserved> fuelReserveds = objectMapper.readValue(value, new TypeReference<List<FuelReserved>>() {});

            for(FuelReserved reserved : fuelReserveds){
                orderId = reserved.getOrderId();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        fuelOrderService.orderReceived(orderId,fuleStatus);
    }

}
