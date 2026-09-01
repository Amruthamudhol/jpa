package com.xworkz.RentRide.service;

import com.xworkz.RentRide.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    boolean save(VehicleDTO dto);
    String saveAll(List<VehicleDTO> dtoList);
    VehicleDTO findVehicleDTOById(Integer id);
    List<VehicleDTO> readAllVehicleDTO();

    VehicleDTO getVehicleByName(String name);
    List<VehicleDTO> getVehicleByBrandAndType(String brand, String vehicleType);
    VehicleDTO getVehicleByModel(String model, Integer id);
    List<VehicleDTO> getVehicleByBrandAndModel(String brand, String model);


}
