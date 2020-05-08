package com.carmanage.service.impl;

import com.carmanage.carDao.CarListDao;
import com.carmanage.entity.CarListEntity;
import com.carmanage.entity.EX.CarListEntityEx;
import com.carmanage.service.CarListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarListServiceImpl implements CarListService {
    @Autowired
    private CarListDao carListDao;

    @Override
    public PageInfo<CarListEntityEx> carListPage(Integer pageNum, Integer pageSize, CarListEntityEx carEntity) {
        PageHelper.startPage(pageNum,pageSize);
        List<CarListEntityEx> carEntityList = carListDao.carListPage(carEntity);
        PageInfo<CarListEntityEx> carEntityPageInfo = new PageInfo<>(carEntityList);
        return carEntityPageInfo;
    }

    @Override
    public void carAdd (String carNumber, int carLicensePlateAreaCode) {
     carListDao.carAdd(carNumber,carLicensePlateAreaCode);
    }

    @Override
    public CarListEntityEx selectCarByCarId(int carId) {
        CarListEntityEx carModel = carListDao.selectCarByCarId(carId);
        return carModel;

    }

    @Override
    public void updateCarByCarId(CarListEntity carListEntity) {
        carListDao.updateCarByCarId(carListEntity);
    }
}
