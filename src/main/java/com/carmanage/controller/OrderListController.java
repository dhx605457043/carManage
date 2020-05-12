package com.carmanage.controller;

import com.carmanage.controller.request.AddOrderRequest;
import com.carmanage.controller.response.OrderSelectAllCarResponse;
import com.carmanage.entity.CargolistEntity;
import com.carmanage.entity.ConsignorlistEntity;
import com.carmanage.entity.EX.OrderListEntityEx;
import com.carmanage.service.CarListService;
import com.carmanage.service.CargoListService;
import com.carmanage.service.ConsignorListService;
import com.carmanage.service.OrderListService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    public OrderListService orderListService;
    @GetMapping("/orderLists")
    public String orderList (Model model) {
        List<OrderListEntityEx> orders = orderListService.selectAllOrder();
        model.addAttribute("orders",orders);
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

    @PostMapping(value = "/orderAdd")
    public String addOrder (@RequestParam("order") String order) {
        JSONObject jsonObject = JSONObject.fromObject(order);
        AddOrderRequest request = (AddOrderRequest) jsonObject.toBean(jsonObject,AddOrderRequest.class);
        orderListService.addOrder(request);
        return "redirect:/orderManage/orderLists";
    }
}
