package com.xworkz.MediCareHub.service;

import com.xworkz.MediCareHub.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    boolean validateAndSave(DoctorDTO dto);
    String saveAll(List<DoctorDTO> dtoList);
    DoctorDTO findDoctorDTOById(Integer id);
    List<DoctorDTO> readAllDoctorDTO();
}
