package com.example.FuelInventory.service;

import com.example.FuelInventory.model.FuelReserved;
import org.springframework.stereotype.Repository;

public interface FuelReservedService {

    public FuelReserved saveReserved(FuelReserved fuelreserved);

    public FuelReserved getFuelReserved(int OrderId, String fueltype, int fuelcapacity, int shedId);

}
