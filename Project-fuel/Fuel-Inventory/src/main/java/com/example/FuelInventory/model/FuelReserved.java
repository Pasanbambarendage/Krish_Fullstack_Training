package com.example.FuelInventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Fuel_Reserved")
public class FuelReserved {

    @Id
    private int orderId;
    private String fuelType;
    private int fuelQuentity;

    private int shedId;


    public FuelReserved(){

    }
    public FuelReserved(int orderId, String fuelType, int fuelQuentity, int shedId) {
        this.orderId = orderId;
        this.fuelType = fuelType;
        this.fuelQuentity = fuelQuentity;
        this.shedId=shedId;
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
