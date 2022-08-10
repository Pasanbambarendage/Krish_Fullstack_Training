package com.example.FuelApplication.listener;

import com.example.FuelApplication.service.FuelOrderService;
import com.example.FuelSchedule.model.FuelSchedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListenerSchedule {

    @Autowired
    FuelOrderService fuelOrderService;

    @KafkaListener(topics = "schedule_topic", groupId = "sample-group")
    public void consumeJson(@Payload List<FuelSchedule> list){

        String value = String.valueOf(list);
        int orderId =0;
        String fuleStatus ="Scheduled";
        String scheduleDate ="";

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<FuelSchedule> fuelSchedules = objectMapper.readValue(value, new TypeReference<List<FuelSchedule>>() {});

            for(FuelSchedule fuelSchedule : fuelSchedules){
                orderId =  fuelSchedule.getOrderID();
                scheduleDate = fuelSchedule.getScheduleDate();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        fuelOrderService.orderSchedule(orderId,fuleStatus,scheduleDate);
    }
}
