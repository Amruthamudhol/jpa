package com.xworkz.RentRide.service.impl;

import com.xworkz.RentRide.dao.VehicleDAO;
import com.xworkz.RentRide.dao.impl.VehicleDAOimpl;
import com.xworkz.RentRide.dto.VehicleDTO;
import com.xworkz.RentRide.entity.VehicleEntity;
import com.xworkz.RentRide.service.VehicleService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    @Override
    public String saveAll(List<VehicleDTO> dtoList) {
        System.out.println("Invoking saveAll : VehicleServiceImpl");
        String isSaved = null;

        if (dtoList != null) {
            System.out.println("List of DTO : " + dtoList);
            List<VehicleEntity> entityList = new ArrayList<>();

            for (VehicleDTO dto : dtoList) {
                VehicleEntity entity = new VehicleEntity();
                entity.setVehicleName(dto.getVehicleName());
                entity.setVehicleType(dto.getVehicleType());
                entity.setBrand(dto.getBrand());
                entity.setModel(dto.getModel());
                entity.setRentPerDay(dto.getRentPerDay());

                entityList.add(entity);
            }

            boolean status = vehicleDAO.saveAll(entityList);

            if (status) {
                isSaved = "Data Saved in database";
            } else {
                isSaved = "Data Not Saved in database";
            }

        } else {

            isSaved = "Data is Empty";
        }

        return isSaved;
    }

    @Override
    public VehicleDTO findVehicleDTOById(Integer id) {
        System.out.println("Invoking findVehicleDTOById : VehicleServiceImpl");
        VehicleEntity entity = vehicleDAO.findVehicleEntityById(id);
        if (entity != null) {

            VehicleDTO dto = new VehicleDTO();

            dto.setVehicleName(entity.getVehicleName());
            dto.setVehicleType(entity.getVehicleType());
            dto.setBrand(entity.getBrand());
            dto.setModel(entity.getModel());
            dto.setRentPerDay(entity.getRentPerDay());

            return dto;
        }

        return null;
    }


    @Override
    public List<VehicleDTO> readAllVehicleDTO() {
        System.out.println("readAllVehicleDTO : VehicleServiceImpl");

        List<VehicleEntity> entityList = vehicleDAO.readAllVehicleEntity();

        List<VehicleDTO> dtoList = entityList.stream()
                .map(entity -> new VehicleDTO(
                        entity.getVehicleName(),
                        entity.getVehicleType(),
                        entity.getBrand(),
                        entity.getModel(),
                        entity.getRentPerDay()
                ))
                .collect(Collectors.toList());

        return dtoList;
    }
    @Override
    public VehicleDTO getVehicleByName(String name) {
        System.out.println("Invoking getVehicleByName : VehicleServiceImpl");
        VehicleDTO vehicleDTO = null;

        VehicleEntity vehicleEntity = vehicleDAO.getVehicleByName(name);

        if (vehicleEntity != null) {

            vehicleDTO = new VehicleDTO(
                    vehicleEntity.getVehicleName(),
                    vehicleEntity.getVehicleType(),
                    vehicleEntity.getBrand(),
                    vehicleEntity.getModel(),
                    vehicleEntity.getRentPerDay()
            );
        }

        return vehicleDTO;
    }


    @Override
    public List<VehicleDTO> getVehicleByBrandAndType(String brand, String vehicleType) {
        System.out.println("Invoking getVehicleByBrandAndType : VehicleServiceImpl");
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        List<VehicleEntity> vehicleEntityList = vehicleDAO.getVehicleByBrandAndType(brand, vehicleType);

        for (VehicleEntity vehicleEntity : vehicleEntityList) {

            VehicleDTO vehicleDTO = new VehicleDTO(vehicleEntity.getVehicleName(), vehicleEntity.getVehicleType(), vehicleEntity.getBrand(), vehicleEntity.getModel(), vehicleEntity.getRentPerDay());
            vehicleDTOList.add(vehicleDTO);
        }

        return vehicleDTOList;
    }



    @Override
    public VehicleDTO getVehicleByModel(String model, Integer id) {
        VehicleDTO vehicleDTO = null;
        VehicleEntity vehicleEntity = vehicleDAO.getVehicleByModel(model, id);

        if (vehicleEntity != null) {

            vehicleDTO = new VehicleDTO(
                    vehicleEntity.getVehicleName(),
                    vehicleEntity.getVehicleType(),
                    vehicleEntity.getBrand(),
                    vehicleEntity.getModel(),
                    vehicleEntity.getRentPerDay()
            );
        }

        return vehicleDTO;
    }



    @Override
    public List<VehicleDTO> getVehicleByBrandAndModel(String brand, String model) {

        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        List<VehicleEntity> vehicleEntityList = vehicleDAO.getVehicleByBrandAndModel(brand, model);

        for (VehicleEntity vehicleEntity : vehicleEntityList) {

            VehicleDTO vehicleDTO = new VehicleDTO(
                    vehicleEntity.getVehicleName(),
                    vehicleEntity.getVehicleType(),
                    vehicleEntity.getBrand(),
                    vehicleEntity.getModel(),
                    vehicleEntity.getRentPerDay()
            );

            vehicleDTOList.add(vehicleDTO);
        }

        return vehicleDTOList;
    }

    @Override
    public String updateBrandAndModelByVehicleName(String vehicleName, String brand, String model) {
        System.out.println("Invoking updateBrandAndModelByVehicleName : Service");

        String status = null;

        if (vehicleName != null && brand != null && model != null) {

            Boolean isUpdated = vehicleDAO.updateBrandAndModelByVehicleName(vehicleName, brand, model);

            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }

    @Override
    public String updateVehicleName(Integer id, String vehicleName) {

        System.out.println("Invoking updateVehicleName : Service");
        String status = null;
        if (id != null && id > 0 && vehicleName != null) {
            Boolean isUpdated = vehicleDAO.updateVehicleName(id, vehicleName);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }


    @Override
    public String updateVehicleType(Integer id, String vehicleType) {
        System.out.println("Invoking updateVehicleType : Service");

        String status = null;
        if (id != null && id > 0 && vehicleType != null) {

            Boolean isUpdated = vehicleDAO.updateVehicleType(id, vehicleType);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }

    @Override
    public List<String> getBrands() {

        System.out.println("getBrands : Service");
        List<String> brands = vehicleDAO.getBrands();

        if (brands != null) {
            return brands;
        }

        return Collections.emptyList();
    }


    @Override
    public List<Object> getModels() {

        System.out.println("getModels : Service");
        List<Object> models = vehicleDAO.getModels();

        if (models != null) {
            return models;
        }

        return Collections.emptyList();
    }
}
