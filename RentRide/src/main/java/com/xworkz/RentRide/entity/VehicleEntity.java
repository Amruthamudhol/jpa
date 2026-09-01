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

@NamedQuery(name = "findVehicleEntityById", query = "SELECT e FROM VehicleEntity e WHERE e.id = :id")
@NamedQuery(name = "getVehicleByName", query = "SELECT e FROM VehicleEntity e WHERE e.vehicleName = :vehicleName")
@NamedQuery(name = "getVehicleByBrandAndType", query = "SELECT e FROM VehicleEntity e WHERE e.brand = :brand AND e.vehicleType = :vehicleType")
@NamedQuery(name = "getVehicleByModel", query = "SELECT e FROM VehicleEntity e WHERE e.model = :model AND e.id = :id")
@NamedQuery(name = "getVehicleByRentPerDay", query = "SELECT e FROM VehicleEntity e WHERE e.rentPerDay = :rentPerDay")
@NamedQuery(name = "getVehicleByBrandAndModel", query = "SELECT e FROM VehicleEntity e WHERE e.brand = :brand AND e.model = :model")





//update
@NamedQuery(name = "updateVehicleName", query = "update VehicleEntity v set v.vehicleName = :vehicleName where v.id = :id")
@NamedQuery(name = "updateVehicleType", query = "update VehicleEntity v set v.vehicleType = :vehicleType where v.id = :id")
@NamedQuery(name = "updateRentPerDay", query = "update VehicleEntity v set v.rentPerDay = :rentPerDay where v.id = :id")

//delete
@NamedQuery(name = "deleteVehicleEntityById", query = "delete from VehicleEntity e where e.id = :id")
@NamedQuery(name = "deleteVehicleByBrand", query = "delete from VehicleEntity v where v.brand = :brand")
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
