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
@NamedQuery(name = "getDoctorsBySpecializationAndExperience", query = "SELECT e FROM DoctorEntity e WHERE e.specialization = :specialization AND e.experience >= :experience")
@NamedQuery(name = "getDoctorsBySpecializationAndEmail", query = "SELECT e FROM DoctorEntity e WHERE e.specialization = :specialization AND e.email = :email")
@NamedQuery(name = "getDoctorsByExperienceAndSpecialization", query = "SELECT e FROM DoctorEntity e WHERE e.experience >= :experience AND e.specialization = :specialization")
@NamedQuery(name = "getDoctorByNameAndSpecialization", query = "SELECT e FROM DoctorEntity e WHERE e.doctorName = :doctorName AND e.specialization = :specialization")
//Update
@NamedQuery(name = "updateDoctorEmailAndPhone", query = "UPDATE DoctorEntity d " + "SET d.email = :email, d.phoneNumber = :phoneNumber " + "WHERE d.id = :id")
@NamedQuery(name = "updateDoctorExperienceByName", query = "UPDATE DoctorEntity d " + "SET d.experience = :experience " + "WHERE d.doctorName = :doctorName")
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
