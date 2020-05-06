package com.carmanage.carDao;

import com.carmanage.entity.EX.CarEntityEx;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarListDao {
    List<CarEntityEx> carListPage (CarEntityEx carEntityEx);
}
