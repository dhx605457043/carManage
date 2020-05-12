package com.carmanage.service;

import com.carmanage.controller.request.AddOrderRequest;
import com.carmanage.entity.EX.OrderListEntityEx;

import java.util.List;

public interface OrderListService {
    void addOrder (AddOrderRequest request);
    List<OrderListEntityEx> selectAllOrder ();
}
