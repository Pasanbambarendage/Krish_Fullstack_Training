package com.example.FuelDispatch.service;

import com.example.FuelDispatch.model.FuelDispatch;
import com.example.FuelDispatch.repository.FuelDispatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelDispatchServiceImpl implements FuelDispatchService{

    @Autowired
    FuelDispatchRepo fuelDispatchRepo;
    @Override
    public FuelDispatch dispatchDelivery(int orderId, String DispatchDate) {

        FuelDispatch fuelDispatch = new FuelDispatch();
        fuelDispatch.setOrderID(orderId);
        fuelDispatch.setScheduleDate(DispatchDate);
        System.out.println("Hi" +orderId+"hi"+ DispatchDate);

        return saveDispatch(fuelDispatch);
    }

    private FuelDispatch saveDispatch(FuelDispatch fuelDispatch) {
        return fuelDispatchRepo.save(fuelDispatch);
    }
    @Override
    public ResponseEntity<List<FuelDispatch>> getAllDispatch() {
        return ResponseEntity.status(HttpStatus.OK).body(fuelDispatchRepo.findAll());
    }


}
