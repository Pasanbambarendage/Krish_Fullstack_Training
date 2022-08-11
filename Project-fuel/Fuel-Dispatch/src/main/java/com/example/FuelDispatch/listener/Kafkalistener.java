package com.example.FuelDispatch.listener;

import com.example.FuelDispatch.model.FuelDispatch;
import com.example.FuelDispatch.service.FuelDispatchService;
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
    FuelDispatchService fuelDispatchService;

    @KafkaListener(topics = "schedule_dispatch_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<FuelDispatch> list){

        String value = String.valueOf(list);
        int OrderID = 0;
        String DispatchDate = "";

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            List<FuelDispatch> fuelDispatches = objectMapper.readValue(value,
                    new TypeReference<List<FuelDispatch>>(){});

            for(FuelDispatch fuelDispatch: fuelDispatches){

                OrderID = fuelDispatch.getOrderID();
                DispatchDate = fuelDispatch.getScheduleDate();
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        fuelDispatchService.dispatchDelivery(OrderID,DispatchDate);
    }
}
