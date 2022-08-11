package com.example.FuelDispatch.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Fuel_Dispatch")
public class FuelDispatch {

    private int orderID;
    private String ScheduleDate;


    public FuelDispatch(){

    }

    public FuelDispatch(int orderID, String scheduleDate) {
        super();
        this.orderID = orderID;
        ScheduleDate = scheduleDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getScheduleDate() {
        return ScheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        ScheduleDate = scheduleDate;
    }
}
