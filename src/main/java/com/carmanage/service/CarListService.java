package com.carmanage.service;

import com.carmanage.entity.EX.CarListEntityEx;
import com.github.pagehelper.PageInfo;

public interface CarListService {
    PageInfo<CarListEntityEx> carListPage (Integer pageNo, Integer pageSize, CarListEntityEx carEntityEx);
//    List<CarEntityEx> driverList (CarEntityEx carEntityEx);
    String carAdd (Integer carNumber);
}
