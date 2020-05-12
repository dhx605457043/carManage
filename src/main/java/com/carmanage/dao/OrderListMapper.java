package com.carmanage.dao;

import com.carmanage.controller.request.AddOrderRequest;
import com.carmanage.entity.EX.OrderListEntityEx;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderListMapper {
    void addOrder (AddOrderRequest request);
    List<OrderListEntityEx> selectAllOrder ();
}
