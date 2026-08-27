package com.xworkz.RentRide.service;

import com.xworkz.RentRide.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    boolean save(VehicleDTO dto);
    String saveAll(List<VehicleDTO> dtoList);
    VehicleDTO findVehicleDTOById(Integer id);
}
