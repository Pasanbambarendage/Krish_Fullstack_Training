package com.example.FuelInventory.service;

import com.example.FuelInventory.model.FuelAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.FuelInventory.repository.FuelAvailableRepo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class FuelAvailableServiceImpl implements FuelAvailableService {

    @Autowired
    FuelAvailableRepo fuelavailablerepo;

    @Autowired
    FuelReservedService fuelReservedService;

    @Override
    public ResponseEntity<FuelAvailable> AvailableStock(FuelAvailable fuelAvailable) {
        int Fuel_ID;
        Random random = new Random();
        Fuel_ID=random.nextInt(100);

        try {
            fuelAvailable.setFuelID(Fuel_ID);
            fuelavailablerepo.save(fuelAvailable);
        }catch (Exception e){

        }

        return ResponseEntity.status(HttpStatus.OK).body(fuelAvailable);
    }

    @Override
    public ResponseEntity<FuelAvailable> UpdateStock(int id, FuelAvailable fuel_available) {
        Optional<FuelAvailable> fuelID = fuelavailablerepo.findById(id);
        if (fuelID.isPresent()){
            FuelAvailable fuelavailable=fuelID.get();
            fuelavailable.setFuelQuantity(fuel_available.getFuelQuantity());
            fuelavailablerepo.save(fuelavailable);

            return ResponseEntity.status(HttpStatus.OK).body(fuelavailable);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public FuelAvailable getQuantity(int orderId, String fuelType, int fuelCapacity) {

        FuelAvailable byFuelType = fuelavailablerepo.findByFuelType(fuelType);
        int ID = byFuelType.getFuelID();
        int availablecapacity = byFuelType.getFuelQuantity();
        String status ="Allocated";
        int Fuel_Balance = availablecapacity - fuelCapacity;
        byFuelType.setFuelQuantity(Fuel_Balance);
        UpdateStock(ID,byFuelType);
        //AvailableStock(byFuelType);
        fuelReservedService.getFuelReserved(orderId,fuelType,fuelCapacity);

        return byFuelType;

    }
}
