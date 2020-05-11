package com.carmanage.service.impl;

import com.carmanage.carDao.DriverListMapper;
import com.carmanage.controller.request.UpdateDriverRequest;
import com.carmanage.controller.response.SelectDriverByIdResponse;
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
    private DriverListMapper driverListDao;
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

    @Override
    public void updateDriver(UpdateDriverRequest request) {
        driverListDao.updateDriver(request);
    }

    @Override
    public SelectDriverByIdResponse selectDriverById(Integer driverId) {
        SelectDriverByIdResponse selectDriverByIdResponse = driverListDao.selectDriverById(driverId);
        return selectDriverByIdResponse;
    }
}
