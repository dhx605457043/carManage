package com.carmanage.service.impl;

import com.carmanage.carDao.CarListDao;
import com.carmanage.entity.CarEntity;
import com.carmanage.entity.EX.CarEntityEx;
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
    public PageInfo<CarEntityEx> carListPage(Integer pageNum, Integer pageSize, CarEntityEx carEntity) {
        PageHelper.startPage(pageNum,pageSize);
        List<CarEntityEx> carEntityList = carListDao.carListPage(carEntity);
        PageInfo<CarEntityEx> carEntityPageInfo = new PageInfo<>(carEntityList);
        return carEntityPageInfo;
    }

//    @Override
//    public List<CarEntityEx> driverList(CarEntityEx carEntityEx) {
//        List<CarEntityEx> carEntityExList = carListDao.carListPage(carEntityEx);
//        return carEntityExList;
//    }
//    @Override
//    public PageInfo<CarEntity> carListPage(Integer pageNo, Integer pageSize, CarEntity carEntity) {
//        PageHelper.startPage(pageNo,pageSize);
//        List<CarEntity> carEntityList = carListDao.carListPage(carEntity);
//        PageInfo<CarEntity> carEntityPageInfo = new PageInfo<>(carEntityList);
//        //        model.addAttribute("pageNo",pageInfo.getPageNum());
////        model.addAttribute("pages",pageInfo.getPages());
////        CarListResponse carListResponse = new CarListResponse(carEntityList,
////                carEntityPageInfo.getPageNum(),
////                carEntityPageInfo.getPages());
//        return carListResponse;
//    }
}
