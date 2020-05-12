package com.carmanage.service;


import com.carmanage.entity.CarLicenseListEntity;

import java.util.List;

public interface CarLicenseListService {
    List<CarLicenseListEntity> selectAllLicense ();
}
