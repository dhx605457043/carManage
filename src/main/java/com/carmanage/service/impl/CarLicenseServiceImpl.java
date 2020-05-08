package com.carmanage.service.impl;

import com.carmanage.carDao.CarLicenseListDao;
import com.carmanage.entity.CarLicenseListEntity;
import com.carmanage.service.CarLicenseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarLicenseServiceImpl implements CarLicenseListService {
    @Autowired
    private CarLicenseListDao carLicenseListDao;
    @Override
    public List<CarLicenseListEntity> selectAllLicense() {
        List<CarLicenseListEntity> licenseListEntities = carLicenseListDao.selectAllLicense();
        return licenseListEntities;
    }
}
