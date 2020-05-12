package com.carmanage.controller;

import com.carmanage.controller.request.UpdateDriverRequest;
import com.carmanage.controller.response.SelectDriverByIdResponse;
import com.carmanage.entity.DriverListEntity;
import com.carmanage.service.DriverListService;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("driverManage")
public class DriverListController {

    @Autowired
    private DriverListService driverListService;
    @GetMapping(value = "/driverLists")
    public String allList (DriverListEntity driverListEntity) {
        List<DriverListEntity> list = driverListService.driverList(driverListEntity);
        return "driver/driverList";
    }
    @GetMapping(value = "/driverListsAll")
    public String driverList (Model model, DriverListEntity driverListEntity, HttpServletRequest request) {
        Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.valueOf(request.getParameter("pageNo"));
        PageInfo<DriverListEntity> pageInfo = driverListService.allDriverList(pageNo,20, driverListEntity);
        List<DriverListEntity> driverListEntities = pageInfo.getList();
        model.addAttribute("searchKey", "");
        model.addAttribute("drivers",driverListEntities);
        model.addAttribute("pageNo",pageInfo.getPageNum());
        model.addAttribute("pages",pageInfo.getPages());
        return "driver/driverList";
    }

    @PostMapping(value = "/updateDriver")
    @ResponseBody
    public void updateDriver (@RequestParam("driver") String driver) {
        JSONObject jsonObject = JSONObject.fromObject(driver);
        UpdateDriverRequest request = (UpdateDriverRequest) JSONObject.toBean(jsonObject,UpdateDriverRequest.class);
        driverListService.updateDriver(request);
    }

    @GetMapping(value = "/driverEdit/{driverId}")
    public String editDriver (Model model,@PathVariable("driverId") int driverId) {
        SelectDriverByIdResponse driverModel = driverListService.selectDriverById(driverId);
        model.addAttribute("driver",driverModel);
        return "driver/driverEdit";
    }

    @PostMapping(value = "/addDriver")
    @ResponseBody
    public void addDriver (@RequestParam("driver") String request) {
        driverListService.addDriver(request);
    }

    @GetMapping(value = "/deleteDriver/{driverId}")
    public String deleteDriver (@PathVariable("driverId") Integer driverId) {
        driverListService.deleteDriver(driverId);
        return "redirect:/driverManage/driverListsAll";
    }
}
