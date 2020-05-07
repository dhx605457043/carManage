package com.carmanage.controller;

import com.carmanage.entity.CarListEntity;
import com.carmanage.entity.EX.CarListEntityEx;
import com.carmanage.service.CarListService;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
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
    public String allList(Model model, CarListEntityEx carEntityEx, HttpServletRequest request) {
        Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.valueOf(request.getParameter("pageNo"));
        PageInfo<CarListEntityEx> pageInfo = carListService.carListPage(pageNo,5,carEntityEx);
        List<CarListEntityEx> carListPage = pageInfo.getList();
        model.addAttribute("searchKey", "");
        model.addAttribute("cars",carListPage);
        model.addAttribute("pageNo",pageInfo.getPageNum());
        model.addAttribute("pages",pageInfo.getPages());
        return "carList";
    }
    @PostMapping(value = "/carAdd")
    @RequestMapping("/addCar")
    @ResponseBody
    public String addCar (@RequestParam("car") String car) {

        JSONObject jsonObject = JSONObject.fromObject(car);
        System.out.println("jsonObject==>" + jsonObject);
        CarListEntity carListEntity = (CarListEntity) JSONObject.toBean(jsonObject, CarListEntity.class);
        carListService.carAdd(carListEntity.getCarNumber());
//        System.out.println(str2);
        return "添加成功";
    }

//    @RequestMapping("/addCar")
//    @ResponseBody
//    public String jsonArrayAdd(@RequestParam("ids") String ids) {
//
////        JSONObject jsonObject = JSONObject.fromObject(ids);
////        System.out.println("jsonObject==>" + jsonObject);
////        Student stu = (Student) JSONObject.toBean(jsonObject, Student.class);
////        System.out.println("stu==>" + stu);
//        return "成功了!";
//    }

}
