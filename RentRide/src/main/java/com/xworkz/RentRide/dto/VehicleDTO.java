package com.xworkz.RentRide.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

    @NotNull(message = "Vehicle Name cannot be null")
    private String vehicleName;

    private String vehicleType;

    @NotNull(message = "Brand name required")
    private String brand;

    @NotNull(message = "Model name required")
    private String model;
    private Double rentPerDay;
    private String status;
}