package com.xworkz.MediCareHub.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "doctor_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "experience")
    private Integer experience;

}
