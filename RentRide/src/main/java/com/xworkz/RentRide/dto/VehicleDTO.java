package com.xworkz.RentRide.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class VehicleDTO {
    private String vehicleName;
    private String vehicleType;
    private String brand;
    private String model;
    private Double rentPerDay;
    private String status;


}
