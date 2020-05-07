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
import java.util.regex.Pattern;

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
        String pattern = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
        boolean isMatch = Pattern.matches(pattern, carListEntity.getCarNumber());
//        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
        if (isMatch) {
            carListService.carAdd(carListEntity.getCarNumber());
            return "添加成功";
        } else  {
            return "请输入正确的车牌号";
        }

//        System.out.println(str2);

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
