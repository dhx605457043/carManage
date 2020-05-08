package com.carmanage.service.impl;

import com.carmanage.carDao.DriverListDao;
import com.carmanage.entity.DriverListEntity;
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
    public List<DriverListEntity> driverList(DriverListEntity driverListEntity) {
        List<DriverListEntity> driverList = driverListDao.driverListPage(driverListEntity);
        return driverList;
    }

//    @Autowired
//    private DriverListDao driverListDao;
    @Override
    public PageInfo<DriverListEntity> allDriverList(Integer pageNo, Integer pageSize, DriverListEntity driverListEntity) {
        PageHelper.startPage(pageNo,pageSize);
        List<DriverListEntity> driEntityList = driverListDao.driverListPage(driverListEntity);
        PageInfo<DriverListEntity> driverEntityPageInfo = new PageInfo<>(driEntityList);
        return driverEntityPageInfo;
    }

    @Override
    public List<DriverListEntity> allDriverListNoPage() {
        List<DriverListEntity> driEntityList = driverListDao.selectAllDriver();
        return driEntityList;
    }
}
