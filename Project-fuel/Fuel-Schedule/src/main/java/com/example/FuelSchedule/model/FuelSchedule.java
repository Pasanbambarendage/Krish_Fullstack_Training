package com.example.FuelSchedule.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Fuel_Schedule")
public class FuelSchedule {

    private int OrderID;
    private String ScheduleDate;

    public FuelSchedule() {
    }

    public FuelSchedule(int orderID, String scheduleDate) {
        super();
        OrderID = orderID;
        ScheduleDate = scheduleDate;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getScheduleDate() {
        return ScheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        ScheduleDate = scheduleDate;
    }

    @Override
    public String toString() {
        return "FuelSchedule{" +
                "OrderID=" + OrderID +
                ", ScheduleDate='" + ScheduleDate + '\'' +
                '}';
    }
}
