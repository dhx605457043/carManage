package com.carmanage.controller;

import com.carmanage.carDao.CarListDao;
import com.carmanage.entity.CarEntity;
import com.carmanage.entity.EX.CarEntityEx;
import com.carmanage.service.CarListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarListController {
    //查询所有车辆
    @Autowired
    private  CarListService carListService;

    @GetMapping(value = "/carLists")
    public String allList(Model model, CarEntityEx carEntityEx, HttpServletRequest request) {
        Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.valueOf(request.getParameter("pageNo"));
        PageInfo<CarEntityEx> pageInfo = carListService.carListPage(pageNo,5,carEntityEx);
        List<CarEntityEx> carListPage = pageInfo.getList();
        model.addAttribute("searchKey", "");
        model.addAttribute("cars",carListPage);
        model.addAttribute("pageNo",pageInfo.getPageNum());
        model.addAttribute("pages",pageInfo.getPages());
        return "carList";
    }

}
