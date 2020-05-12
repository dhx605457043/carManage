package com.carmanage.service.impl;

import com.carmanage.controller.request.AddOrderRequest;
import com.carmanage.dao.OrderListMapper;
import com.carmanage.entity.EX.OrderListEntityEx;
import com.carmanage.entity.OrderlistEntity;
import com.carmanage.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {
    @Autowired
    public OrderListMapper orderListMapper;

    @Override
    public void addOrder(AddOrderRequest request) {
        orderListMapper.addOrder(request);
    }

    @Override
    public List<OrderListEntityEx> selectAllOrder() {
        List<OrderListEntityEx> responses = orderListMapper.selectAllOrder();
        return responses;
    }
}
