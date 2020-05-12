package com.carmanage.controller;

import com.carmanage.controller.request.AddOrderRequest;
import com.carmanage.controller.request.UpdateOrderRequest;
import com.carmanage.controller.response.OrderSelectAllCarResponse;
import com.carmanage.entity.CarLicenseListEntity;
import com.carmanage.entity.CargolistEntity;
import com.carmanage.entity.ConsignorlistEntity;
import com.carmanage.entity.EX.CarListEntityEx;
import com.carmanage.entity.EX.OrderListEntityEx;
import com.carmanage.entity.OrderlistEntity;
import com.carmanage.service.CarListService;
import com.carmanage.service.CargoListService;
import com.carmanage.service.ConsignorListService;
import com.carmanage.service.OrderListService;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String orderList (Model model,OrderListEntityEx orderListEntityEx, HttpServletRequest request) {
        Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.valueOf(request.getParameter("pageNo"));
        PageInfo<OrderListEntityEx> pageInfo = orderListService.selectAllOrder(pageNo,20,orderListEntityEx);
        List<OrderListEntityEx> orders = pageInfo.getList();
        model.addAttribute("orders",orders);
        model.addAttribute("pageNo",pageInfo.getPageNum());
        model.addAttribute("pages",pageInfo.getPages());
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

    @GetMapping(value = "/toOrderEdit/{orderId}")
    public String toOrderEdit (Model model, @PathVariable("orderId") int orderId) {
        OrderListEntityEx order = orderListService.selectOrderById(orderId);
        List<OrderSelectAllCarResponse> cars = carListService.orderSelectAllCar();
        List<ConsignorlistEntity> consignors = consignorListService.selectAll();
        List<CargolistEntity> cargos = cargoListService.selectAll();
        model.addAttribute("cars",cars);
        model.addAttribute("consignors",consignors);
        model.addAttribute("cargos",cargos);
        model.addAttribute("order",order);
        return "/order/orderEdit";
    }

    @PostMapping(value = "/updateOrderWithConditions")

    @ResponseBody
    public String updateOrder (@RequestParam("order") String order) {
        JSONObject jsonObject = JSONObject.fromObject(order);
        UpdateOrderRequest request = (UpdateOrderRequest) JSONObject.toBean(jsonObject, UpdateOrderRequest.class);
        orderListService.updateOrderWithConditions(request);
        return "cg";
    }

    @GetMapping(value = "/deleteOrderById/{orderId}")
    public String deleteOrder(@PathVariable int orderId) {
        orderListService.deleteOrderById(orderId);
        return "redirect:/orderManage/orderLists";
    }
}
