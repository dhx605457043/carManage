package com.carmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderListController {

    @GetMapping("/orderLists")
    public String orderList () {
        return "orderList";
    }
}
