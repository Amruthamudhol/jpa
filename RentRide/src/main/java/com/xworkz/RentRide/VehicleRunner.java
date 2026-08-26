package com.xworkz.RentRide;

import com.xworkz.RentRide.dto.VehicleDTO;
import com.xworkz.RentRide.service.VehicleService;
import com.xworkz.RentRide.service.impl.VehicleServiceImpl;

public class VehicleRunner {
    public static void main(String[] args) {

        VehicleDTO dto = new VehicleDTO("Swift", "Car", "Maruti", "2024", 1500.0);

        VehicleService service = new VehicleServiceImpl();
        boolean isSaved = service.save(dto);
    }
}
