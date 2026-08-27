package com.xworkz.MediCareHub;

import com.xworkz.MediCareHub.dto.DoctorDTO;
import com.xworkz.MediCareHub.service.DoctorService;
import com.xworkz.MediCareHub.service.impl.DoctorServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class DoctorRunner {
    public static void main(String[] args) {

            DoctorDTO dto = new DoctorDTO("Dr.Amruta", "Cardiologist", "amruta@gmail.com", 9876543210L, 10);
            DoctorService service = new DoctorServiceImpl();
            boolean isSaved = service.validateAndSave(dto);

        List<DoctorDTO> doctorDTOList = new ArrayList<>();

        doctorDTOList.add(new DoctorDTO("Dr. Ravi Kumar", "Cardiologist", "ravi@gmail.com", 9876543210L, 10));
        doctorDTOList.add(new DoctorDTO("Dr. Priya Sharma", "Dermatologist", "priya@gmail.com", 9876543211L, 7));
        doctorDTOList.add(new DoctorDTO("Dr. Anil Kumar", "Neurologist", "anil@gmail.com", 9876543212L, 12));
        String savedStatus = service.saveAll(doctorDTOList);
        System.out.println(savedStatus);


        DoctorDTO dtoById = service.findDoctorDTOById(1);
        System.out.println("Found Dto is : " + dtoById);
        }

}
