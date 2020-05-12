package com.carmanage.dao;

import com.carmanage.controller.request.AddOrderRequest;
import com.carmanage.controller.request.UpdateOrderRequest;
import com.carmanage.entity.EX.CarListEntityEx;
import com.carmanage.entity.EX.OrderListEntityEx;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderListMapper {
    void addOrder (AddOrderRequest request);
    List<OrderListEntityEx> selectAllOrder (OrderListEntityEx orderListEntityEx);
    OrderListEntityEx selectOrderById (Integer orderId);
    void upDateOrderWithConditions (UpdateOrderRequest request);
    void deleteOrderById (Integer orderId);
}
