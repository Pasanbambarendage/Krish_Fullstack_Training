package com.example.FuelInventory.service;

import com.example.FuelInventory.model.FuelReserved;
import com.example.FuelInventory.repository.FuelReservedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelReservedServiceImpl implements FuelReservedService {

    @Autowired
    FuelReservedRepo fuelreservedrepo;


    @Override
    public FuelReserved saveReserved(FuelReserved fuelReserved) {
        return fuelreservedrepo.save(fuelReserved);
    }

    @Override
    public FuelReserved getFuelReserved(int OrderId, String fueltype, int fuelcapacity) {
        FuelReserved reserved = new FuelReserved();
        reserved.setOrderId(OrderId);
        reserved.setFuelType(fueltype);
        reserved.setFuelQuentity(fuelcapacity);
        return saveReserved(reserved);

    }

}
