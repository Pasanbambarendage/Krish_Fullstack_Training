package com.example.FuelInventory.service;

import com.example.FuelInventory.model.FuelReserved;
import org.springframework.stereotype.Repository;

public interface FuelReservedService {

    public FuelReserved saveReserved(FuelReserved fuel_reserved);

    public FuelReserved getFuelReserved(int OrderId, String fueltype, int fuelcapacity);

}
