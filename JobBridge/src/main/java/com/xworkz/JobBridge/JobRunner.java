package com.xworkz.JobBridge;

import com.xworkz.JobBridge.dto.JobDTO;
import com.xworkz.JobBridge.service.JobService;
import com.xworkz.JobBridge.service.impl.JobServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class JobRunner {
    public static void main(String[] args) {

        JobDTO dto = new JobDTO("Java Developer", "Infosys", "Bangalore", "Full Time", 60000.0);
        JobService service = new JobServiceImpl();
        boolean isSaved = service.validateAndSave(dto);
        if (isSaved) {
            System.out.println("Job saved successfully");
        } else {
            System.out.println("Job not saved");
        }


        List<JobDTO> jobDTOList = new ArrayList<>();
        jobDTOList.add(new JobDTO("Java Developer", "Infosys", "Bangalore", "Full Time", 60000.0));
        jobDTOList.add(new JobDTO("Python Developer", "TCS", "Bangalore", "Full Time", 55000.0));
        jobDTOList.add(new JobDTO("Software Engineer", "Wipro", "Mysore", "Full Time", 50000.));
        String savedStatus = service.saveAll(jobDTOList);
        System.out.println(savedStatus);



        JobDTO dtoById = service.findJobDTOById(3);
        System.out.println("Found Dto is : " + dtoById);
    }
    }


