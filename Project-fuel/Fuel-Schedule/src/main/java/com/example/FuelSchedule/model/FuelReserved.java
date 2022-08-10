package com.example.FuelSchedule.model;

public class FuelReserved {

    private int orderId;
    private String fuelType;
    private int fuelQuentity;

    private int shedId;
    public FuelReserved(){}

    public FuelReserved(int orderId, String fuelType, int fuelQuentity, int shedId) {
        super();
        this.orderId = orderId;
        this.fuelType = fuelType;
        this.fuelQuentity = fuelQuentity;
        this.shedId = shedId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getFuelQuentity() {
        return fuelQuentity;
    }

    public void setFuelQuentity(int fuelQuentity) {
        this.fuelQuentity = fuelQuentity;
    }

    public int getShedId() {
        return shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }
}
