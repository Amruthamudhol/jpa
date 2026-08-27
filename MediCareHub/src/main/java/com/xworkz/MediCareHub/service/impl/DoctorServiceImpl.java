package com.xworkz.MediCareHub.service.impl;

import com.xworkz.MediCareHub.dao.DoctorDAO;
import com.xworkz.MediCareHub.dao.impl.DoctorDAOimpl;
import com.xworkz.MediCareHub.dto.DoctorDTO;
import com.xworkz.MediCareHub.entity.DoctorEntity;
import com.xworkz.MediCareHub.service.DoctorService;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    public String saveAll(List<DoctorDTO> dtoList) {

        System.out.println("Invoking saveAll : DoctorServiceImpl");
        String isSaved = null;
        if (dtoList != null) {
            System.out.println("List of DTO : " + dtoList);
            List<DoctorEntity> entityList = new ArrayList<>();

            for (DoctorDTO dto : dtoList) {
                DoctorEntity entity = new DoctorEntity();

                entity.setDoctorName(dto.getDoctorName());
                entity.setSpecialization(dto.getSpecialization());
                entity.setEmail(dto.getEmail());
                entity.setPhoneNumber(dto.getPhoneNumber());
                entity.setExperience(dto.getExperience());
                entityList.add(entity);
            }

            boolean status = doctorDAO.saveAll(entityList);

            if (status) {
                isSaved = "Data Saved in database";
            } else {
                isSaved = "Data Not Saved in database";
            }

        } else {
            isSaved = "Data is Empty";
        }
        return isSaved;
    }



    @Override
    public DoctorDTO findDoctorDTOById(Integer id) {

        System.out.println("Invoking findDoctorDTOById : DoctorServiceImpl");

        DoctorEntity entity = doctorDAO.findDoctorEntityById(id);

        if (entity != null) {

            DoctorDTO dto = new DoctorDTO();
            dto.setDoctorName(entity.getDoctorName());
            dto.setSpecialization(entity.getSpecialization());
            dto.setEmail(entity.getEmail());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setExperience(entity.getExperience());

            return dto;
        }

        return null;
    }
}
