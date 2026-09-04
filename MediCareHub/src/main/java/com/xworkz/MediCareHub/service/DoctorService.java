package com.xworkz.MediCareHub.service;

import com.xworkz.MediCareHub.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    boolean validateAndSave(DoctorDTO dto);
    String saveAll(List<DoctorDTO> dtoList);
    DoctorDTO findDoctorDTOById(Integer id);
    List<DoctorDTO> readAllDoctorDTO();
    List<DoctorDTO> getDoctorsBySpecializationAndExperience(String specialization, Integer experience);
    List<DoctorDTO> getDoctorsBySpecializationAndEmail(String specialization, String email);
    List<DoctorDTO> getDoctorsByExperienceAndSpecialization(Integer experience, String specialization);
    DoctorDTO getDoctorByNameAndSpecialization(String doctorName, String specialization);
    String updateDoctorEmailAndPhone(Integer id, String email, Long phoneNumber);
    String updateDoctorExperienceByName(String doctorName, Integer experience);
    List<String> getDoctorNames();
    List<Long> getPhoneNumbers();
    List<Object> getEmails();
    List<Object[]> getDoctorNameAndSpecialization();
    List<List<Object>> getDoctorNameAndEmail();



}
