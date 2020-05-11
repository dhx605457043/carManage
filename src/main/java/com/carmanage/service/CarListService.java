package com.carmanage.service;

import com.carmanage.controller.response.OrderSelectAllCarResponse;
import com.carmanage.entity.CarListEntity;
import com.carmanage.entity.EX.CarListEntityEx;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CarListService {
    PageInfo<CarListEntityEx> carListPage (Integer pageNo, Integer pageSize, CarListEntityEx carEntityEx);
    void carAdd (String carNumber,int carLicensePlateAreaCode);
    CarListEntityEx selectCarByCarId (int carId);
    void updateCarByCarId(CarListEntity carListEntity);
    boolean selectCarByNumber (String carNumber);
    void deleteCarById (int carId);
    List<OrderSelectAllCarResponse> orderSelectAllCar();
}
