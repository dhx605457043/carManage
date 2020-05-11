package com.carmanage.dao;


import com.carmanage.controller.request.AddDriverRequest;
import com.carmanage.controller.request.UpdateDriverRequest;
import com.carmanage.controller.response.SelectDriverByIdResponse;
import com.carmanage.entity.DriverListEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverListMapper {
    List<DriverListEntity> driverListPage (DriverListEntity driverListEntity);
    List<DriverListEntity> selectAllDriver ();
    void updateDriver (UpdateDriverRequest request);
    SelectDriverByIdResponse selectDriverById (Integer driverId);
    void addDriver (AddDriverRequest request);
    void deleteDriver (Integer driverId);
}
