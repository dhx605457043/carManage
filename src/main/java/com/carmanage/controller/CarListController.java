package com.carmanage.controller;

import com.carmanage.entity.CarLicenseListEntity;
import com.carmanage.entity.CarListEntity;
import com.carmanage.entity.DriverListEntity;
import com.carmanage.entity.EX.CarListEntityEx;
import com.carmanage.service.CarLicenseListService;
import com.carmanage.service.CarListService;
import com.carmanage.service.DriverListService;
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
@RequestMapping("/carManage")
public class CarListController {
    //查询所有车辆
    @Autowired
    private  CarListService carListService;
    @Autowired
    private DriverListService driverListService;

    @Autowired
    private CarLicenseListService carLicenseListService;

    @GetMapping(value = "/carLists")
    public String allList(Model model, CarListEntityEx carEntityEx, HttpServletRequest request) {
        Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.valueOf(request.getParameter("pageNo"));
        PageInfo<CarListEntityEx> pageInfo = carListService.carListPage(pageNo,20,carEntityEx);
        List<CarListEntityEx> carListPage = pageInfo.getList();
        List<CarLicenseListEntity> licenseListEntities = carLicenseListService.selectAllLicense();

        model.addAttribute("licenses",licenseListEntities);
        model.addAttribute("searchKey", "");
        model.addAttribute("cars",carListPage);
        model.addAttribute("pageNo",pageInfo.getPageNum());
        model.addAttribute("pages",pageInfo.getPages());
        return "car/carList";
    }
    //        @PostMapping(value = "/carAdd")
    @PostMapping("/addCar")
    @ResponseBody
    public String addCar (@RequestParam("car") String car) {

        JSONObject jsonObject = JSONObject.fromObject(car);
        CarListEntityEx carListEntity = (CarListEntityEx) JSONObject.toBean(jsonObject, CarListEntityEx.class);
        String pattern = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
        boolean isMatch = Pattern.matches(pattern, carListEntity.getLicensePlateAreaName() + carListEntity.getCarNumber());
        if (isMatch) {
            boolean code = carListService.selectCarByNumber(carListEntity.getCarNumber());
            if (code) {
                carListService.carAdd(carListEntity.getCarNumber(),carListEntity.getCarLicensePlateAreaCode());
                return "添加成功";
            } else  {
                return "车辆存在，请勿重复添加";
            }
        } else  {
            return "请输入正确的车牌号";
        }

//        return "0";
    }

    @GetMapping(value = "/carEdit/{carId}")
    public String carEdit (Model model,@PathVariable("carId") int carId) {
        List<CarLicenseListEntity> licenseListEntities = carLicenseListService.selectAllLicense();
        List<DriverListEntity> driverListEntities = driverListService.allDriverListNoPage();
        CarListEntityEx car = carListService.selectCarByCarId(carId);
        model.addAttribute("licenses",licenseListEntities);
        model.addAttribute("car",car);
        model.addAttribute("drivers",driverListEntities);
        return "car/carEdit";
    }

    @PostMapping(value = "/updateCar")
//    @ResponseBody
    public String updateCar (@RequestParam("car") String car) {
        JSONObject jsonObject = JSONObject.fromObject(car);
//        System.out.println("jsonObject==>" + jsonObject);
        CarListEntity carListEntity = (CarListEntity) JSONObject.toBean(jsonObject, CarListEntity.class);
        carListService.updateCarByCarId(carListEntity);
        return "test";
    }
    @GetMapping(value = "/deleteCar/{carId}")
    public String delectCar (@PathVariable("carId") int carId) {
        carListService.deleteCarById(carId);
        return "redirect:/carManage/carLists";
    }
}
