package com.example.FuelSchedule.service;

import com.example.FuelSchedule.config.KafkaTopicConfig;
import com.example.FuelSchedule.model.FuelSchedule;
import com.example.FuelSchedule.repository.FuelScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FuelScheduleServiceImple implements FuelScheduleService{

    @Autowired
    FuelScheduleRepo fuelScheduleRepo;

    @Autowired
    KafkaTemplate<String, FuelSchedule> kafkaTemplate;


    @Override
    public List<FuelSchedule> getAllDeliveryDate() {
        return fuelScheduleRepo.findAll();
    }

    @Override
    public FuelSchedule deliverDate(int OrderId) {
        FuelSchedule fuelSchedule = new FuelSchedule();
        fuelSchedule.setOrderID(OrderId);
        fuelSchedule.setScheduleDate(LocalDate.now().plusDays(1).toString());
        saveSchedule(fuelSchedule);

        return fuelSchedule;
    }

    @Override
    public FuelSchedule saveSchedule(FuelSchedule fuelSchedule) {
        kafkaTemplate.send(KafkaTopicConfig.MESSAGE_TOPIC,fuelSchedule);
        return fuelScheduleRepo.save(fuelSchedule);
    }
}