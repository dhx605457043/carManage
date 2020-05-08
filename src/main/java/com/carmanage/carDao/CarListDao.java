package com.carmanage.carDao;

import com.carmanage.entity.CarListEntity;
import com.carmanage.entity.EX.CarListEntityEx;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarListDao {
    List<CarListEntityEx> carListPage (CarListEntityEx carEntityEx);
   void carAdd (String carNumber,int carLicensePlateAreaCode);
   CarListEntityEx selectCarByCarId (int carId);
   void updateCarByCarId (CarListEntity carListEntity);
}
