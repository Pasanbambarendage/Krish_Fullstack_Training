package com.example.FuelDispatch.controller;

import com.example.FuelDispatch.model.FuelDispatch;
import com.example.FuelDispatch.service.FuelDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/dispatch")
@CrossOrigin
public class FuelDispatchController {

    @Autowired
    FuelDispatchService fuelDispatchService;

    @GetMapping
    public ResponseEntity<List<FuelDispatch>> getAllDispatch(){
        return fuelDispatchService.getAllDispatch();
    }
}
