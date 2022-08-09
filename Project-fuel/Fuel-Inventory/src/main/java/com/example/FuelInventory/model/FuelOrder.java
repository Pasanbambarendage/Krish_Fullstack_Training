package com.example.FuelInventory.model;

import org.springframework.data.annotation.Id;

public class FuelOrder {
    @Id
    private int orderID;
    private String shedName;
    private int shedId;
    private String shedLocation;
    private int capacity;
    private String fuelType;
    private String status ="Pending";

    private String scheduleDate ="Pending";

    public FuelOrder(){

    }

    public FuelOrder(int orderID, String shedName, int shedId, String shedLocation, int capacity, String fuelType, String status, String scheduleDate) {
        this.orderID = orderID;
        this.shedName = shedName;
        this.shedId = shedId;
        this.shedLocation = shedLocation;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.status = status;
        this.scheduleDate = scheduleDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getShedName() {
        return shedName;
    }

    public void setShedName(String shedName) {
        this.shedName = shedName;
    }

    public int getShedId() {
        return shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }

    public String getShedLocation() {
        return shedLocation;
    }

    public void setShedLocation(String shedLocation) {
        this.shedLocation = shedLocation;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    @Override
    public String toString() {
        return "FuelOrder{" +
                "orderID=" + orderID +
                ", shedName='" + shedName + '\'' +
                ", shedId=" + shedId +
                ", shedLocation='" + shedLocation + '\'' +
                ", capacity=" + capacity +
                ", fuelType='" + fuelType + '\'' +
                ", status='" + status + '\'' +
                ", scheduleDate='" + scheduleDate + '\'' +
                '}';
    }
}
