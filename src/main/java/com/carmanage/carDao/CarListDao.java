package com.carmanage.carDao;

import com.carmanage.entity.EX.CarListEntityEx;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarListDao {
    List<CarListEntityEx> carListPage (CarListEntityEx carEntityEx);
    String carAdd (Integer carNumber);
}
