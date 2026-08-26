package com.xworkz.RentRide.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDTO {
    private String vehicleName;
    private String vehicleType;
    private String brand;
    private String model;
    private Double rentPerDay;
}
