package com.carmanage.controller.request;

import lombok.Data;

@Data
public class AddOrderRequest {
    private Integer ownerOfCargo;
    private Integer goodsName;
    private String orderDate;
    private Integer driverCost;
    private Integer chinaCost;
    private Integer koreaCost;
    private Integer freight;
    private Integer orderCar;
    private Integer profit;
    private Integer orderType;
    private Integer quarantineCost;
    private String carNumber;
}
