package com.carmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("orderManage")
public class OrderListController {

    @GetMapping("/orderLists")
    public String orderList () {
        return "/order/orderList";
    }
}
