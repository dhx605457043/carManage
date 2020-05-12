package com.carmanage.dao;

import com.carmanage.entity.ConsignorlistEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsignorListMapper {
    List<ConsignorlistEntity> selectAll ();
}
