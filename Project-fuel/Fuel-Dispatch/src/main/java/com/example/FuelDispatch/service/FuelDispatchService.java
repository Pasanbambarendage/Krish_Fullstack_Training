package com.example.FuelDispatch.service;


import com.example.FuelDispatch.model.FuelDispatch;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FuelDispatchService {
   public FuelDispatch dispatchDelivery( int OrderID, String DispatchDate);

    public ResponseEntity<List<FuelDispatch>> getAllDispatch();
}
