package com.example.FuelSchedule.service;

import com.example.FuelSchedule.model.FuelSchedule;

import java.util.List;

public interface FuelScheduleService {
    public List<FuelSchedule> getAllDeliveryDate();

    public FuelSchedule deliverDate(int OrderId);

    public FuelSchedule saveSchedule(FuelSchedule fuelSchedule);

}
