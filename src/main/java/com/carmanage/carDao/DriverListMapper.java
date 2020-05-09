package com.carmanage.carDao;

import com.carmanage.entity.DriverListEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverListMapper {
    List<DriverListEntity> driverListPage (DriverListEntity driverListEntity);
    List<DriverListEntity> selectAllDriver ();

}
