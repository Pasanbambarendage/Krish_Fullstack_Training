package com.example.FuelInventory.listener;

import com.example.FuelInventory.model.FuelOrder;
import com.example.FuelInventory.service.FuelAvailableService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Kafklistener {

    @Autowired
    FuelAvailableService fuelavailableservice;

    @KafkaListener(topics = "order_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<FuelOrder> list){

        String value = String.valueOf(list);
        int orderId =0;
        String fuelType = "";
        String fuelStatus = "";
        int fuelCapacity = 0;
        int shedId = 0;

        ObjectMapper objectMapper = new ObjectMapper();
        try{
            List<FuelOrder> orders = objectMapper.readValue(value, new TypeReference<List<FuelOrder>>() {});
            for(FuelOrder fuelOrder: orders){
                orderId= fuelOrder.getOrderID();
                fuelType =fuelOrder.getFuelType();
                fuelCapacity = fuelOrder.getCapacity();
                fuelStatus = fuelOrder.getStatus();
                shedId = fuelOrder.getShedId();

                //System.out.println(fuelOrder.toString());
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        fuelavailableservice.getQuantity(orderId,fuelType,fuelCapacity,shedId);
    }
}
