package com.carmanage.carDao;

import com.carmanage.entity.CarLicenseListEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarLicenseListDao {
    List<CarLicenseListEntity> selectAllLicense ();
}
