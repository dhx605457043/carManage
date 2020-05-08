package com.carmanage.service;

import com.carmanage.entity.DriverListEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DriverListService {
    List<DriverListEntity> driverList (DriverListEntity driverListEntity);
    PageInfo<DriverListEntity> allDriverList (Integer pageNo, Integer pageSize, DriverListEntity driverListEntity);
    List<DriverListEntity> allDriverListNoPage ();

}
