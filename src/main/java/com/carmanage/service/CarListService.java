package com.carmanage.service;

import com.carmanage.entity.CarListEntity;
import com.carmanage.entity.EX.CarListEntityEx;
import com.github.pagehelper.PageInfo;

public interface CarListService {
    PageInfo<CarListEntityEx> carListPage (Integer pageNo, Integer pageSize, CarListEntityEx carEntityEx);
    void carAdd (String carNumber,int carLicensePlateAreaCode);
    CarListEntityEx selectCarByCarId (int carId);
    void updateCarByCarId(CarListEntity carListEntity);
    boolean selectCarByNumber (String carNumber);
    void deleteCarById (int carId);
}
