package com.carmanage.controller.request;

import lombok.Data;

@Data
public class AddDriverRequest {
    private String driverName;
    private String driverAddress;
    private String driverPhoneNumber;
    private String driverIDCard;
}
