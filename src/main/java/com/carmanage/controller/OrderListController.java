package com.carmanage.controller;

import com.carmanage.controller.response.OrderSelectAllCarResponse;
import com.carmanage.service.CarListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("orderManage")
public class OrderListController {
    @Autowired
    CarListService carListService;
    @GetMapping("/orderLists")
    public String orderList () {
        return "/order/orderList";
    }

    @GetMapping(value = "/toOrderAdd")
    public String toOrderAdd (Model model) {
        List<OrderSelectAllCarResponse> cars = carListService.orderSelectAllCar();
        model.addAttribute("cars",cars);
        return "/order/orderAdd";
    }
}
