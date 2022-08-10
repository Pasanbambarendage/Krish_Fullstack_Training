package com.example.FuelSchedule.service;

import com.example.FuelSchedule.model.FuelSchedule;

import java.util.List;

public interface FuelScheduleService {
    public FuelSchedule deliveryDate(int OrderId);

    public FuelSchedule saveSchedule(FuelSchedule fuelSchedule);

    public List<FuelSchedule> getAllDeliveryDate();
}
