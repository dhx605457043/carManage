package com.carmanage.service;

import com.carmanage.controller.request.AddOrderRequest;
import com.carmanage.controller.request.UpdateOrderRequest;
import com.carmanage.entity.EX.CarListEntityEx;
import com.carmanage.entity.EX.OrderListEntityEx;
import com.carmanage.entity.OrderlistEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderListService {
    void addOrder (AddOrderRequest request);
//    PageInfo<CarListEntityEx> carListPage (Integer pageNo, Integer pageSize, CarListEntityEx carEntityEx);

    PageInfo<OrderListEntityEx> selectAllOrder (Integer pageNo, Integer pageSize, OrderListEntityEx orderListEntityEx);
    void updateOrderWithConditions (UpdateOrderRequest request);
    void deleteOrderById (Integer orderId);
    OrderListEntityEx selectOrderById (Integer orderId);
}
