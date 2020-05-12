package com.carmanage.service.impl;

import com.carmanage.dao.CargoListMapper;
import com.carmanage.entity.CargolistEntity;
import com.carmanage.service.CargoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoListServiceImpl implements CargoListService {
    @Autowired
    private CargoListMapper cargoListModel;

    @Override
    public List<CargolistEntity> selectAll() {
        List<CargolistEntity> respons = cargoListModel.selectAll();
        return respons;
    }
}
