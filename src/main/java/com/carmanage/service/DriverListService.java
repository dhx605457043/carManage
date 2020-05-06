package com.carmanage.service;

import com.carmanage.entity.DriverEntity;
import com.carmanage.entity.EX.CarEntityEx;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DriverListService {
    List<DriverEntity> driverList (DriverEntity driverEntity);
    PageInfo<DriverEntity> allDriverList (Integer pageNo, Integer pageSize, DriverEntity driverEntity);
}
