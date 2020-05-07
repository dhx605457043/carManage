package com.carmanage.entity.EX;

import com.carmanage.entity.CarListEntity;

public class CarListEntityEx extends CarListEntity {
    private String driverName;
    private String driverAddress;
    private int driverId;
    private int driverPhoneNumber;
    private String driverIDCard;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(int driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public String getDriverIDCard() {
        return driverIDCard;
    }

    public void setDriverIDCard(String driverIDCard) {
        this.driverIDCard = driverIDCard;
    }
}
