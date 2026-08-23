package com.xworkz.redbus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "booking_info")
@Getter
@Setter
@ToString
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email_Id")
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "booking_date")
    private String bookingDate;

    @Column(name = "number_of_people")
    private Integer numberOfPeople;
}
