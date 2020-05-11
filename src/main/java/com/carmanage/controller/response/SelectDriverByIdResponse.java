package com.carmanage.controller.response;

import lombok.Data;

@Data
public class SelectDriverByIdResponse {
    private String driverName;
    private String driverAddress;
    private int driverId;
    private String driverPhoneNumber;
    private String driverIDCard;
}
