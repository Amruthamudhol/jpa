package com.xworkz.RentRide;

import com.xworkz.RentRide.dto.VehicleDTO;
import com.xworkz.RentRide.service.VehicleService;
import com.xworkz.RentRide.service.impl.VehicleServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class VehicleRunner {
    public static void main(String[] args) {


        VehicleDTO dto1 = new VehicleDTO("Activa 7G", "Scooter", "Honda", "6G", 500.0);

        VehicleService service = new VehicleServiceImpl();
        // boolean isSaved = service.save(dto1);


        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        vehicleDTOList.add(new VehicleDTO("Activa 6G", "Scooter", "Honda", "6G", 500.0));
        vehicleDTOList.add(new VehicleDTO("Royal Enfield Classic 350", "Bike", "Royal Enfield", "Classic 350", 800.0));
        vehicleDTOList.add(new VehicleDTO("Apache RTR 160", "Bike", "TVS", "RTR 160", 700.0));
        vehicleDTOList.add(new VehicleDTO("HONDA", "Car", "Maruti", "2024", 1500.0));
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


        // VehicleDTO dto = service.getVehicleByModel("2024", 1);
        //  System.out.println("Vehicle DTO : " + dto);

        // List<VehicleDTO> dtoList = service.getVehicleByBrandAndModel("Honda", "6G");
        //  dtoList.forEach(a -> System.out.println(a));

        //String status = service.updateBrandAndModelByVehicleName("Activa 6G", "Bajaj", "8G");
        // System.out.println("Status : " + status);

        // String status = service.updateVehicleName(1, "Royal Enfield");
        //  System.out.println("Status : " + status);

        //   String status = service.updateVehicleType(1, "Electric");
        //  System.out.println("Status : " + status);


        // List<String> brands = service.getBrands();
        // for (String brand : brands) {
        //     System.out.println(brand);

       // List<Object> models = service.getModels();
       // System.out.println(models);

       // List<Object[]> vehicles =service.getVehicleNameAndBrand();
      //  for (Object[] vehicle : vehicles) {
          //  System.out.println("Vehicle Name: " + vehicle[0]);
       //     System.out.println("Brand: " + vehicle[1]);
      //  }


        List<List<Object>> vehicles1= service.getVehicleNameAndModel();
        for (List<Object> vehicle : vehicles1) {
            System.out.println("Vehicle Name: " + vehicle.get(0));
            System.out.println("Model: " + vehicle.get(1));
        }
    }
}
