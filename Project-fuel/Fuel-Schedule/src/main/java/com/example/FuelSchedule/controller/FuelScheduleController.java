package com.example.FuelSchedule.controller;

import com.example.FuelSchedule.model.FuelSchedule;
import com.example.FuelSchedule.service.FuelScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/schedules")
@CrossOrigin
public class FuelScheduleController {

    @Autowired
    FuelScheduleService fuelScheduleService;

    @GetMapping("/scheduledate")
    public List<FuelSchedule> getAllDeliveryDate(){

        return fuelScheduleService.getAllDeliveryDate();
    }

}
