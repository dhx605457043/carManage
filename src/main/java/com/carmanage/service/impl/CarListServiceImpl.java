package com.carmanage.service.impl;



import com.carmanage.controller.response.OrderSelectAllCarResponse;
import com.carmanage.dao.CarListMapper;
import com.carmanage.entity.CarListEntity;
import com.carmanage.entity.EX.CarListEntityEx;
import com.carmanage.service.CarListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarListServiceImpl implements CarListService {
    @Autowired
    private CarListMapper carListMapper;

    @Override
    public PageInfo<CarListEntityEx> carListPage(Integer pageNum, Integer pageSize, CarListEntityEx carEntity) {
        PageHelper.startPage(pageNum,pageSize);
        List<CarListEntityEx> carEntityList = carListMapper.carListPage(carEntity);
        PageInfo<CarListEntityEx> carEntityPageInfo = new PageInfo<>(carEntityList);
        return carEntityPageInfo;
    }

    @Override
    public void carAdd (String carNumber, int carLicensePlateAreaCode) {
        carListMapper.carAdd(carNumber,carLicensePlateAreaCode);
    }

    @Override
    public CarListEntityEx selectCarByCarId(int carId) {
        CarListEntityEx carModel = carListMapper.selectCarByCarId(carId);
        return carModel;

    }

    @Override
    public void updateCarByCarId(CarListEntity carListEntity) {
        carListMapper.updateCarByCarId(carListEntity);
    }

    @Override
    public boolean selectCarByNumber(String carNumber) {
        Integer code = carListMapper.selectCarByCarNumber(carNumber);

        return code == null ? true : false;
    }

    @Override
    public void deleteCarById(int carId) {
        carListMapper.deleteCarByCarId(carId);
    }

    @Override
    public List<OrderSelectAllCarResponse> orderSelectAllCar() {
        List<OrderSelectAllCarResponse> responses = carListMapper.orderSelectAllCar();
        return responses;
    }
}
