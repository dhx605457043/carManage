package com.carmanage.service.impl;

import com.carmanage.controller.request.AddOrderRequest;
import com.carmanage.controller.request.UpdateOrderRequest;
import com.carmanage.dao.OrderListMapper;
import com.carmanage.entity.EX.CarListEntityEx;
import com.carmanage.entity.EX.OrderListEntityEx;
import com.carmanage.entity.OrderlistEntity;
import com.carmanage.service.OrderListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<OrderListEntityEx> selectAllOrder(Integer pageNo, Integer pageSize, OrderListEntityEx orderListEntityEx) {
        PageHelper.startPage(pageNo,pageSize);
        List<OrderListEntityEx> orderListEntityExes = orderListMapper.selectAllOrder(orderListEntityEx);
        PageInfo<OrderListEntityEx> entityExPageInfo = new PageInfo<>(orderListEntityExes);
        return entityExPageInfo;
    }

    @Override
    public void updateOrderWithConditions(UpdateOrderRequest request) {
        orderListMapper.upDateOrderWithConditions(request);
    }

    @Override
    public OrderListEntityEx selectOrderById(Integer orderId) {
        OrderListEntityEx response = orderListMapper.selectOrderById(orderId);
        return response;
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        orderListMapper.deleteOrderById(orderId);
    }
}
