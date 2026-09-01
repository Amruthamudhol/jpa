package com.xworkz.RentRide;

import com.xworkz.RentRide.dto.VehicleDTO;
import com.xworkz.RentRide.service.VehicleService;
import com.xworkz.RentRide.service.impl.VehicleServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class VehicleRunner {
    public static void main(String[] args) {


        VehicleDTO dto1 = new VehicleDTO("Activa 7G","Scooter","Honda","6G",500.0);

       VehicleService service = new VehicleServiceImpl();
       // boolean isSaved = service.save(dto1);



        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        vehicleDTOList.add(new VehicleDTO("Activa 6G","Scooter","Honda","6G",500.0));
        vehicleDTOList.add(new VehicleDTO("Royal Enfield Classic 350","Bike","Royal Enfield","Classic 350",800.0));
        vehicleDTOList.add(new VehicleDTO("Apache RTR 160","Bike","TVS","RTR 160",700.0));
        vehicleDTOList.add(new VehicleDTO("HONDA","Car","Maruti","2024",1500.0));
     // String savedStatus = service.saveAll(vehicleDTOList);

     //  System.out.println(savedStatus);


      // VehicleDTO dtoById = service.findVehicleDTOById(1);
      // System.out.println("Found Dto is : " + dtoById);

//getall
     //   List<VehicleDTO> vehicleDTOList1= service.readAllVehicleDTO();
     //  vehicleDTOList1.forEach(a -> System.out.println(a));

        //VehicleDTO dto2 = service.getVehicleByName("Activa 7G");
       // System.out.println("Vehicle DTO : " + dto2);



        //List<VehicleDTO> list = service.getVehicleByBrandAndType("Honda", "Scooter");
       // list.forEach(a -> System.out.println(a));


        VehicleDTO dto = service.getVehicleByModel("2024", 1);
        System.out.println("Vehicle DTO : " + dto);

        List<VehicleDTO> dtoList = service.getVehicleByBrandAndModel("Honda", "6G");
        dtoList.forEach(a -> System.out.println(a));



    }
}
