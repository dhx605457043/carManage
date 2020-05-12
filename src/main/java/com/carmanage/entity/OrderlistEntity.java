package com.carmanage.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderlistEntity {
    private Integer orderId;
    private String ownerOfCargo;
    private String goodsName;
    private Date orderDate;
    private Integer driverCost;
    private Integer chinaCost;
    private Integer koreaCost;
    private Integer freight;
    private Integer orderCar;
    private Integer profit;
    private Integer orderType;
}
