package com.example.FuelSchedule.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="FuelSchedule")
public class FuelSchedule {

    @Id
    private int OrderID;
    private String ScheduleDate;

    public FuelSchedule(){

    }
    
    public FuelSchedule(int orderID, String scheduleDate) {
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
}
