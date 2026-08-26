package com.xworkz.RentRide.service.impl;

import com.xworkz.RentRide.dao.VehicleDAO;
import com.xworkz.RentRide.dao.impl.VehicleDAOimpl;
import com.xworkz.RentRide.dto.VehicleDTO;
import com.xworkz.RentRide.entity.VehicleEntity;
import com.xworkz.RentRide.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {

    VehicleDAO vehicleDAO = new VehicleDAOimpl();

    @Override
    public boolean save(VehicleDTO dto) {
        System.out.println("Invoking validateAndSave : VehicleServiceImpl");
        boolean isSaved = false;

        if (dto != null) {
            VehicleEntity entity = new VehicleEntity();

            entity.setVehicleName(dto.getVehicleName());
            entity.setVehicleType(dto.getVehicleType());
            entity.setBrand(dto.getBrand());
            entity.setModel(dto.getModel());
            entity.setRentPerDay(dto.getRentPerDay());

            boolean saved = vehicleDAO.save(entity);

            if (saved) {
                isSaved = true;
                System.out.println("Data Saved");
            } else {
                isSaved = false;
                System.out.println("Data Not Saved");
            }

        } else {

            System.out.println("Data is Empty");
        }

        return isSaved;
    }}
