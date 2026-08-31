package com.xworkz.RentRide;

import com.xworkz.RentRide.dto.VehicleDTO;
import com.xworkz.RentRide.service.VehicleService;
import com.xworkz.RentRide.service.impl.VehicleServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class VehicleRunner {
    public static void main(String[] args) {

        VehicleDTO dto = new VehicleDTO("Swift", "Car", "Maruti", "2024", 1500.0);

        VehicleService service = new VehicleServiceImpl();
        boolean isSaved = service.save(dto);



        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        vehicleDTOList.add(new VehicleDTO("Activa 6G","Scooter","Honda","6G",500.0));
        vehicleDTOList.add(new VehicleDTO("Royal Enfield Classic 350","Bike","Royal Enfield","Classic 350",800.0));
        vehicleDTOList.add(new VehicleDTO("Apache RTR 160","Bike","TVS","RTR 160",700.0));
        String savedStatus = service.saveAll(vehicleDTOList);

        System.out.println(savedStatus);


        VehicleDTO dtoById = service.findVehicleDTOById(1);
        System.out.println("Found Dto is : " + dtoById);

//getall
        List<VehicleDTO> vehicleDTOList1= service.readAllVehicleDTO();
        vehicleDTOList1.forEach(a -> System.out.println(a));
    }
}
