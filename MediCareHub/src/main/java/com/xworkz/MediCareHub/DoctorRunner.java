package com.xworkz.MediCareHub;

import com.xworkz.MediCareHub.dto.DoctorDTO;
import com.xworkz.MediCareHub.service.DoctorService;
import com.xworkz.MediCareHub.service.impl.DoctorServiceImpl;

public class DoctorRunner {
    public static void main(String[] args) {


            DoctorDTO dto = new DoctorDTO("Dr.Amruta", "Cardiologist", "amruta@gmail.com", 9876543210L, 10);

            DoctorService service = new DoctorServiceImpl();
            boolean isSaved = service.validateAndSave(dto);
        }

}
