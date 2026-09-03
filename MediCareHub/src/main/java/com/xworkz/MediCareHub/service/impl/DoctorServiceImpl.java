package com.xworkz.MediCareHub.service.impl;

import com.xworkz.MediCareHub.dao.DoctorDAO;
import com.xworkz.MediCareHub.dao.impl.DoctorDAOimpl;
import com.xworkz.MediCareHub.dto.DoctorDTO;
import com.xworkz.MediCareHub.entity.DoctorEntity;
import com.xworkz.MediCareHub.service.DoctorService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public List<DoctorDTO> readAllDoctorDTO() {

        System.out.println("readAllDoctorDTO : DoctorServiceImpl");
        List<DoctorEntity> entityList = doctorDAO.readAllDoctorEntity();

        List<DoctorDTO> dtoList = entityList.stream()
                .map(entity -> new DoctorDTO(
                        entity.getDoctorName(),
                        entity.getSpecialization(),
                        entity.getEmail(),
                        entity.getPhoneNumber(),
                        entity.getExperience()
                ))
                .collect(Collectors.toList());
        return dtoList;
    }


    @Override
    public List<DoctorDTO> getDoctorsBySpecializationAndExperience(String specialization, Integer experience) {

        List<DoctorDTO> dtoList = new ArrayList<>();
        List<DoctorEntity> entityList = doctorDAO.getDoctorsBySpecializationAndExperience(specialization, experience);

        for (DoctorEntity entity : entityList) {

            DoctorDTO dto = new DoctorDTO();
            dto.setDoctorName(entity.getDoctorName());
            dto.setSpecialization(entity.getSpecialization());
            dto.setEmail(entity.getEmail());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setExperience(entity.getExperience());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpecializationAndEmail(String specialization, String email) {

        List<DoctorDTO> dtoList = new ArrayList<>();

        List<DoctorEntity> entityList = doctorDAO.getDoctorsBySpecializationAndEmail(specialization, email);

        for (DoctorEntity entity : entityList) {
            DoctorDTO dto = new DoctorDTO();

            dto.setDoctorName(entity.getDoctorName());
            dto.setSpecialization(entity.getSpecialization());
            dto.setEmail(entity.getEmail());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setExperience(entity.getExperience());

            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public List<DoctorDTO> getDoctorsByExperienceAndSpecialization(Integer experience, String specialization) {

        List<DoctorDTO> dtoList = new ArrayList<>();

        List<DoctorEntity> entityList = doctorDAO.getDoctorsByExperienceAndSpecialization(experience, specialization);

        for (DoctorEntity entity : entityList) {

            DoctorDTO dto = new DoctorDTO();

            dto.setDoctorName(entity.getDoctorName());
            dto.setSpecialization(entity.getSpecialization());
            dto.setEmail(entity.getEmail());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setExperience(entity.getExperience());

            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public DoctorDTO getDoctorByNameAndSpecialization(String doctorName, String specialization) {

        DoctorEntity entity = doctorDAO.getDoctorByNameAndSpecialization(doctorName, specialization);

        DoctorDTO dto = null;

        if (entity != null) {

            dto = new DoctorDTO();

            dto.setDoctorName(entity.getDoctorName());
            dto.setSpecialization(entity.getSpecialization());
            dto.setEmail(entity.getEmail());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setExperience(entity.getExperience());
        }

        return dto;
    }


    @Override
    public String updateDoctorEmailAndPhone(Integer id, String email, Long phoneNumber) {

        System.out.println("Invoking updateDoctorEmailAndPhone : Service");
        String status = null;

        if (id != null && id > 0 && email != null && phoneNumber != null) {
            Boolean isUpdated = doctorDAO.updateDoctorEmailAndPhone(id, email, phoneNumber);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }


    @Override
    public String updateDoctorExperienceByName(String doctorName, Integer experience) {

        System.out.println("Invoking updateDoctorExperienceByName : Service");
        String status = null;

        if (doctorName != null && experience != null) {

            Boolean isUpdated = doctorDAO.updateDoctorExperienceByName(doctorName, experience);

            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }

    @Override
    public List<String> getDoctorNames() {

        System.out.println("getDoctorNames : Service");

        List<String> foundNames = doctorDAO.getDoctorNames();

        if (foundNames != null) {
            return foundNames;
        }

        return Collections.emptyList();
    }
    @Override
    public List<Long> getPhoneNumbers() {
        System.out.println("getPhoneNumbers : Service");
        List<Long> phoneNumbers = doctorDAO.getPhoneNumbers();
        if (phoneNumbers != null) {
            return phoneNumbers;
        }
        return Collections.emptyList();
    }

    @Override
    public List<Object> getEmails() {
        System.out.println("getEmails : Service");
        List<Object> emails = doctorDAO.getEmails();

        if (emails != null) {
            return emails;
        }

        return Collections.emptyList();
    }


}
