package com.carmanage.controller;

import com.carmanage.carDao.CarListDao;
import com.carmanage.entity.CarEntity;
import com.carmanage.response.CarListResponse;
import com.carmanage.service.CarListService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarManageController {

//    private Object CarListResponse;

//    @GetMapping(value = "/carView")
//    public String carView() {
//        return "car";
//    }
    //    @Autowired
//    private CarListDao carListDao;
//    @Autowired
//    CarListService carListService;
//    @Autowired
//    CarListResponse carListResponse;

//    @ResponseBody
//    @PostMapping("/getCarList")
//    public CarListResponse getCarList(CarEntity carEntity,HttpServletRequest request) {
//        Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.valueOf(request.getParameter("pageNo"));
//        CarListResponse carListResponse = carListService.carListPage(pageNo,5,carEntity);
//        System.out.println("pageNo" + pageNo);
////        List<CarEntity> carListPage = pageInfo.getList();
//
////        model.addAttribute("searchKey", "");
////        model.addAttribute("cars",carListPage);
////        model.addAttribute("pageNo",pageInfo.getPageNum());
////        model.addAttribute("pages",pageInfo.getPages());
//
//        return carListResponse;
//    }

}
