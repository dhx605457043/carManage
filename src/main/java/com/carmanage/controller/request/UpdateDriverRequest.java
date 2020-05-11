package com.carmanage.controller.request;

import lombok.Data;

@Data
public class UpdateDriverRequest {
    private String driverName;
    private String driverAddress;
    private int driverId;
    private String driverPhoneNumber;
    private String driverIDCard;
}
