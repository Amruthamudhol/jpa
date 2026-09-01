package com.xworkz.MediCareHub.dao;

import com.xworkz.MediCareHub.entity.DoctorEntity;

import java.util.List;

public interface DoctorDAO {
    boolean save(DoctorEntity entity);
    boolean saveAll(List<DoctorEntity> entityList);
    DoctorEntity findDoctorEntityById(Integer id);

    List<DoctorEntity> readAllDoctorEntity();
    List<DoctorEntity> getDoctorsBySpecializationAndExperience(String specialization, Integer experience);
    List<DoctorEntity> getDoctorsBySpecializationAndEmail(String specialization, String email);
    List<DoctorEntity> getDoctorsByExperienceAndSpecialization(Integer experience, String specialization);
    DoctorEntity getDoctorByNameAndSpecialization(String doctorName, String specialization);
}
