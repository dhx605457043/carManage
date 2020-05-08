package com.carmanage.entity;

public class CarListEntity {
    private int carId;
    private String carNumber;
    private int carDriverId;
//    private String carLicensePlateAreaName;
    private int carLicensePlateAreaCode;

    public int getCarLicensePlateAreaCode() {
        return carLicensePlateAreaCode;
    }

    public void setCarLicensePlateAreaCode(int carLicensePlateAreaCode) {
        this.carLicensePlateAreaCode = carLicensePlateAreaCode;
    }

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

    public int getCarDriverId() {
        return carDriverId;
    }

    public void setCarDriverId(int carDriverId) {
        this.carDriverId = carDriverId;
    }
}
