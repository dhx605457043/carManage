package com.carmanage.service.impl;

import com.carmanage.carDao.CarListDao;
import com.carmanage.carDao.DriverListDao;
import com.carmanage.entity.DriverEntity;
import com.carmanage.entity.EX.CarEntityEx;
import com.carmanage.service.DriverListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverListServiceImpl implements DriverListService {

    @Autowired
    private DriverListDao driverListDao;
    @Override
    public List<DriverEntity> driverList(DriverEntity driverEntity) {
        List<DriverEntity> driverList = driverListDao.driverListPage(driverEntity);
        return driverList;
    }

//    @Autowired
//    private DriverListDao driverListDao;
    @Override
    public PageInfo<DriverEntity> allDriverList(Integer pageNo, Integer pageSize, DriverEntity driverEntity) {
        PageHelper.startPage(pageNo,pageSize);
        List<DriverEntity> carEntityList = driverListDao.driverListPage(driverEntity);
        PageInfo<DriverEntity> driverEntityPageInfo = new PageInfo<>(carEntityList);
        return driverEntityPageInfo;
    }
}
