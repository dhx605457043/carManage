package com.carmanage.controller;

import com.carmanage.entity.DriverListEntity;
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
    public String allList (DriverListEntity driverListEntity) {
        List<DriverListEntity> list = driverListService.driverList(driverListEntity);
        return "driverList";
    }
    @GetMapping(value = "/driverListsAll")
    public String driverList (Model model, DriverListEntity driverListEntity, HttpServletRequest request) {
        Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.valueOf(request.getParameter("pageNo"));
        PageInfo<DriverListEntity> pageInfo = driverListService.allDriverList(pageNo,5, driverListEntity);
        List<DriverListEntity> carListPage = pageInfo.getList();
        model.addAttribute("searchKey", "");
        model.addAttribute("cars",carListPage);
        model.addAttribute("pageNo",pageInfo.getPageNum());
        model.addAttribute("pages",pageInfo.getPages());
        return "driverList";
    }
}
