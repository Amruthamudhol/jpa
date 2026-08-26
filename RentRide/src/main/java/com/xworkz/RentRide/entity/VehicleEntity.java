package com.xworkz.RentRide.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vehicle_name")
    private String vehicleName;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "rent_per_day")
    private Double rentPerDay;
}
