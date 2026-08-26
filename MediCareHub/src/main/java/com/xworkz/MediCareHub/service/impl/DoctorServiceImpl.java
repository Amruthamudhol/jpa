package com.xworkz.MediCareHub.service.impl;

import com.xworkz.MediCareHub.dao.DoctorDAO;
import com.xworkz.MediCareHub.dao.impl.DoctorDAOimpl;
import com.xworkz.MediCareHub.dto.DoctorDTO;
import com.xworkz.MediCareHub.entity.DoctorEntity;
import com.xworkz.MediCareHub.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {
    DoctorDAO doctorDAO = new DoctorDAOimpl();

    @Override
    public boolean validateAndSave(DoctorDTO dto) {

        System.out.println("Invoking validateAndSave : DoctorServiceImpl");
        boolean isSaved = false;

        if (dto != null) {
            DoctorEntity entity = new DoctorEntity();

            entity.setDoctorName(dto.getDoctorName());
            entity.setSpecialization(dto.getSpecialization());
            entity.setEmail(dto.getEmail());
            entity.setPhoneNumber(dto.getPhoneNumber());
            entity.setExperience(dto.getExperience());

            boolean saved = doctorDAO.save(entity);

            if (saved) {
                isSaved = true;
                System.out.println("Data Saved");
            } else {
                isSaved = false;
                System.out.println("Data Not Saved");
            }
        } else {
            System.out.println("Data is Empty");
        }

        return isSaved;
    }
}
