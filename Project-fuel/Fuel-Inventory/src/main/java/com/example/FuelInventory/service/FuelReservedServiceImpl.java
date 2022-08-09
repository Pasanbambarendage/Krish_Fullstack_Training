package com.example.FuelInventory.service;

import com.example.FuelInventory.config.KafkaTopicConfig;
import com.example.FuelInventory.config.KafkaTopicOrder;
import com.example.FuelInventory.model.FuelReserved;
import com.example.FuelInventory.repository.FuelReservedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FuelReservedServiceImpl implements FuelReservedService {

    @Autowired
    FuelReservedRepo fuelreservedrepo;

    @Autowired
    KafkaTemplate<String, FuelReserved> kafkaTemplate;


    @Override
    public FuelReserved saveReserved(FuelReserved fuelReserved) {
        kafkaTemplate.send(KafkaTopicConfig.MESSAGE_TOPIC,fuelReserved);
        kafkaTemplate.send(KafkaTopicOrder.MESSAGE_TOPIC,fuelReserved);
        return fuelreservedrepo.save(fuelReserved);
    }

    @Override
    public FuelReserved getFuelReserved(int OrderId, String fueltype, int fuelcapacity, int shedId) {
        FuelReserved reserved = new FuelReserved();
        reserved.setOrderId(OrderId);
        reserved.setFuelType(fueltype);
        reserved.setFuelQuentity(fuelcapacity);
        reserved.setShedId(shedId);
        return saveReserved(reserved);

    }

}
