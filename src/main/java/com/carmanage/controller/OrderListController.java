package com.carmanage.controller;

import com.carmanage.controller.response.OrderSelectAllCarResponse;
import com.carmanage.entity.CargolistEntity;
import com.carmanage.entity.ConsignorlistEntity;
import com.carmanage.service.CarListService;
import com.carmanage.service.CargoListService;
import com.carmanage.service.ConsignorListService;
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
    private CarListService carListService;
    @Autowired
    private ConsignorListService consignorListService;
    @Autowired
    private CargoListService cargoListService;
    @GetMapping("/orderLists")
    public String orderList () {
        return "/order/orderList";
    }

    @GetMapping(value = "/toOrderAdd")
    public String toOrderAdd (Model model) {
        List<OrderSelectAllCarResponse> cars = carListService.orderSelectAllCar();
        List<ConsignorlistEntity> consignors = consignorListService.selectAll();
        List<CargolistEntity> cargos = cargoListService.selectAll();
        model.addAttribute("cars",cars);
        model.addAttribute("consignors",consignors);
        model.addAttribute("cargos",cargos);

        return "/order/orderAdd";
    }
}
