package com.carmanage.service;

import com.carmanage.entity.CarEntity;
import com.carmanage.entity.EX.CarEntityEx;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CarListService {
    PageInfo<CarEntityEx> carListPage (Integer pageNo, Integer pageSize, CarEntityEx carEntityEx);
//    List<CarEntityEx> driverList (CarEntityEx carEntityEx);
}
