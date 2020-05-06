package com.carmanage.controller;

import com.carmanage.entity.DriverEntity;
import com.carmanage.entity.EX.CarEntityEx;
import com.carmanage.service.DriverListService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DriverListController {

    @Autowired
    private DriverListService driverListService;
    @GetMapping(value = "/driverLists")
    public String allList (DriverEntity driverEntity) {
        List<DriverEntity> list = driverListService.driverList(driverEntity);
        return "driverList";
    }
    @GetMapping(value = "/driverListsAll")
    public String driverList (Model model, DriverEntity driverEntity, HttpServletRequest request) {
        Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.valueOf(request.getParameter("pageNo"));
        PageInfo<DriverEntity> pageInfo = driverListService.allDriverList(pageNo,5,driverEntity);
        List<DriverEntity> carListPage = pageInfo.getList();
        model.addAttribute("searchKey", "");
        model.addAttribute("cars",carListPage);
        model.addAttribute("pageNo",pageInfo.getPageNum());
        model.addAttribute("pages",pageInfo.getPages());
        return "driverList";
    }
}
