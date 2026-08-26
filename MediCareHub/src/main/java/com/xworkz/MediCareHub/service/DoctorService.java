package com.xworkz.MediCareHub.service;

import com.xworkz.MediCareHub.dto.DoctorDTO;

public interface DoctorService {
    boolean validateAndSave(DoctorDTO dto);
}
