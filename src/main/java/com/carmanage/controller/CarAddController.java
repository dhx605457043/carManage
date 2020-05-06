package com.carmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarAddController {

    @PostMapping(value = "/addCar")
    public String addCar () {
        return "insert";
    }
}
