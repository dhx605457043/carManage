package com.carmanage.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderlistEntity {
    private Integer orderid;
    private String ownerofcargo;
    private String goodsname;
    private Date orderdate;
    private Integer drivercost;
    private Integer chinacost;
    private Integer koreacost;
    private Integer freight;
    private Integer ordercar;
    private Integer profit;
    private Integer ordertype;
}
