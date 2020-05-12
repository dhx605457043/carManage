package com.carmanage.dao;

import com.carmanage.entity.CargolistEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoListMapper {
    List<CargolistEntity> selectAll();
}
