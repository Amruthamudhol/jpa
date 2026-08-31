package com.xworkz.RentRide.dao;

import com.xworkz.RentRide.entity.VehicleEntity;

import java.util.List;

public interface VehicleDAO {
    boolean save(VehicleEntity entity);
    boolean saveAll(List<VehicleEntity> entityList);
    VehicleEntity findVehicleEntityById(Integer id);
    List<VehicleEntity> readAllVehicleEntity();
}
