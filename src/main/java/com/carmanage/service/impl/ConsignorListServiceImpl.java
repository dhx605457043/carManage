package com.carmanage.service.impl;

import com.carmanage.dao.ConsignorListMapper;
import com.carmanage.entity.ConsignorlistEntity;
import com.carmanage.service.ConsignorListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsignorListServiceImpl implements ConsignorListService {
    @Autowired
    private ConsignorListMapper consignorListModel;

    @Override
    public List<ConsignorlistEntity> selectAll() {
        List<ConsignorlistEntity> respons = consignorListModel.selectAll();
        return respons;
    }
}
