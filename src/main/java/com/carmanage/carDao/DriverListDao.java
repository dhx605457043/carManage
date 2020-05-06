package com.carmanage.carDao;

import com.carmanage.entity.DriverEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverListDao {
    List<DriverEntity> driverListPage (DriverEntity driverEntity);
}
