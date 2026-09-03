package com.xworkz.MediCareHub;

import com.xworkz.MediCareHub.dto.DoctorDTO;
import com.xworkz.MediCareHub.service.DoctorService;
import com.xworkz.MediCareHub.service.impl.DoctorServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class DoctorRunner {
    public static void main(String[] args) {

           // DoctorDTO dto = new DoctorDTO("Dr.Amruta", "Cardiologist", "amruta@gmail.com", 9876543210L, 10);
           DoctorService service = new DoctorServiceImpl();
          //  boolean isSaved = service.validateAndSave(dto);

        List<DoctorDTO> doctorDTOList = new ArrayList<>();

        doctorDTOList.add(new DoctorDTO("Dr. Ravi Kumar", "Cardiologist", "ravi@gmail.com", 9876543210L, 10));
        doctorDTOList.add(new DoctorDTO("Dr. Priya Sharma", "Dermatologist", "priya@gmail.com", 9876543211L, 7));
        doctorDTOList.add(new DoctorDTO("Dr. Anil Kumar", "Neurologist", "anil@gmail.com", 9876543212L, 12));
       // String savedStatus = service.saveAll(doctorDTOList);
      //  System.out.println(savedStatus);


       // DoctorDTO dtoById = service.findDoctorDTOById(1);
       // System.out.println("Found Dto is : " + dtoById);


       // List<DoctorDTO> doctorDTOList1 = service.readAllDoctorDTO();
     //   doctorDTOList1.forEach(a -> System.out.println(a));

      //  List<DoctorDTO> list = service.getDoctorsBySpecializationAndExperience("Cardiologist", 5);
       // list.forEach(a -> System.out.println(a));

       // List<DoctorDTO> list = service.getDoctorsBySpecializationAndEmail("Cardiologist", "ravi@gmail.com");
      //  list.forEach(a -> System.out.println(a));

      //  List<DoctorDTO> list = service.getDoctorsByExperienceAndSpecialization(10, "Cardiologist");
      //list.forEach(a -> System.out.println(a));

     //   DoctorDTO dto = service.getDoctorByNameAndSpecialization("Dr. Anjali Sharma", "Cardiologist");
      //  System.out.println("Doctor DTO : " + dto);

     //   String status = service.updateDoctorEmailAndPhone(1, "doctor@gmail.com", 9876543210L);
     //   System.out.println("Status : " + status);

        //String status = service.updateDoctorExperienceByName("Dr.Amruta", 8);
       // System.out.println("Status : " + status);

      //  List<String> names = service.getDoctorNames();
       // System.out.println(names);

      //  List<Long> phoneNumbers = service.getPhoneNumbers();
      //  System.out.println(phoneNumbers);


        List<Object> emails = service.getEmails();
        for (Object email : emails) {
            System.out.println(email);
        }
    }

}
