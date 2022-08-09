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
    public FuelAvailable getQuantity(int orderId, String fueltype, int fuelCapacity, int shedId) {
        System.out.println("full details----"+orderId+ fueltype +fuelCapacity +shedId);
        FuelAvailable byFuelType = fuelavailablerepo.findByFuelType(fueltype);
        System.out.println("type---"+byFuelType.getFuelType());
        int ID = byFuelType.getFuelID();
        int availablecapacity = byFuelType.getFuelQuantity();
        System.out.println();

        if (availablecapacity>=fuelCapacity){
            int FuelBalance = availablecapacity - fuelCapacity;
            byFuelType.setFuelQuantity(FuelBalance);
            UpdateStock(ID,byFuelType);
            fuelReservedService.getFuelReserved(orderId, fueltype,fuelCapacity,shedId);
        }

        return byFuelType;

    }
}
