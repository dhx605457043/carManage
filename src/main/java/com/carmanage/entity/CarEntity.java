package com.carmanage.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class CarEntity {
    private int carId;
    private String carNumber;
    private String carDriverId;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarDriverId() {
        return carDriverId;
    }

    public void setCarDriverId(String carDriverId) {
        this.carDriverId = carDriverId;
    }
}
