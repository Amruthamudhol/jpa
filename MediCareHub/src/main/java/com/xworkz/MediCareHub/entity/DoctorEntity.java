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

//Read
@NamedQuery(name = "findDoctorEntity", query = "SELECT d FROM DoctorEntity d ")
@NamedQuery(name = "findDoctorBySpecialization", query = "SELECT d FROM DoctorEntity d WHERE d.specialization = :specialization")
@NamedQuery(name = "findDoctorByExperience", query = "SELECT d FROM DoctorEntity d WHERE d.experience > :experience")
@NamedQuery(name = "findDoctorByEmail", query = "SELECT d FROM DoctorEntity d WHERE d.email = :email")
@NamedQuery(name = "findDoctorByPhoneNumber", query = "SELECT d FROM DoctorEntity d WHERE d.phoneNumber = :phoneNumber")

//Update
@NamedQuery(name = "updateDoctorEmail", query = "UPDATE DoctorEntity d SET d.email = :email WHERE d.id = :id")
@NamedQuery(name = "updateDoctorExperience", query = "UPDATE DoctorEntity d SET d.experience = :experience WHERE d.id = :id")
@NamedQuery(name = "updateDoctorSpecialization", query = "UPDATE DoctorEntity d SET d.specialization = :specialization WHERE d.id = :id")

//delete
@NamedQuery(name = "deleteDoctor", query = "DELETE FROM DoctorEntity d WHERE d.id = :id")
@NamedQuery(name = "deleteDoctorBySpecialization", query = "DELETE FROM DoctorEntity d WHERE d.specialization = :specialization")



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
