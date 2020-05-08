package com.carmanage.controller;

import com.carmanage.entity.CarLicenseListEntity;
import com.carmanage.service.CarLicenseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarLicenseController {
    @Autowired
    private CarLicenseListService carLicenseListService;

    @GetMapping(value = "/selecAllLicense")
    public String selectLicense (Model model) {
        List<CarLicenseListEntity> licenseListEntities = carLicenseListService.selectAllLicense();
//        System.out.println(licenseListEntities);
//        model.addAllAttributes("",licenseListEntities);licenseListEntities
        model.addAttribute("licenses",licenseListEntities);
        return "carList";
    }
}
