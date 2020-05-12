package com.carmanage.entity.EX;

import com.carmanage.entity.OrderlistEntity;
import lombok.Data;

@Data
public class OrderListEntityEx extends OrderlistEntity {
    private String cargoName;
    private String consignorName;
    private String carNumber;
    private String licensePlateAreaName;
}
