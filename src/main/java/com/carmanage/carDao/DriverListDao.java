package com.carmanage.carDao;

import com.carmanage.entity.DriverListEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverListDao {
    List<DriverListEntity> driverListPage (DriverListEntity driverListEntity);
    List<DriverListEntity> selectAllDriver ();

}
