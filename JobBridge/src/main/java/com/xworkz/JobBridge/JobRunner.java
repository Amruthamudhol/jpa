package com.xworkz.JobBridge;

import com.xworkz.JobBridge.dto.JobDTO;
import com.xworkz.JobBridge.service.JobService;
import com.xworkz.JobBridge.service.impl.JobServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class JobRunner {
    public static void main(String[] args) {

      // JobDTO dto = new JobDTO("Java Developer", "Infosys", "Bangalore", "Full Time", 60000.0);
       // JobDTO dto1 = new JobDTO("data analyst", "Infosys", "Bangalore", "Full Time", 60000.0);
        JobDTO dto2 = new JobDTO("Manager", "Infosys", "Bangalore", "Full Time", 60000.0);

        JobService service = new JobServiceImpl();
      // boolean isSaved = service.validateAndSave(dto2);
       //if (isSaved) {
         //  System.out.println("Job saved successfully");
      // } else {
      //      System.out.println("Job not saved");
      //  }


      //  List<JobDTO> jobDTOList = new ArrayList<>();
       // jobDTOList.add(new JobDTO("Java Developer", "Infosys", "Bangalore", "Full Time", 60000.0));
       // jobDTOList.add(new JobDTO("Python Developer", "TCS", "Bangalore", "Full Time", 55000.0));
      //  jobDTOList.add(new JobDTO("Software Engineer", "Wipro", "Mysore", "Full Time", 50000.));
     //   String savedStatus = service.saveAll(jobDTOList);
       // System.out.println(savedStatus);



        //JobDTO dtoById = service.findJobDTOById(3);
        //System.out.println("Found Dto is : " + dtoById);


        //  getAll
      //  List<JobDTO> jobDTOList1 = service.readAllJobDTO();
        //jobDTOList1.forEach(a -> System.out.println(a));

       // List<JobDTO> list = service.getJobsByCompanyAndLocation("TCS", "Bangalore");
        //list.forEach(a -> System.out.println(a));

        //List<JobDTO> list = service.getJobsByTypeAndLocation("Full Time", "Bangalore");
        //list.forEach(a -> System.out.println(a));

       // JobDTO dto = service.getJobByTitleAndCompany("data analyst", "Infosys");
       //System.out.println("Job DTO : " + dto);

       // JobDTO dto = service.getJobByCompanyTypeLocation("Infosys", "Full Time", "Bangalore");
       // System.out.println("Job DTO : " + dto);

        //String status = service.updateJobTitleAndCompanyName(1, "Full-Stack Developer", "Amazon");
       // System.out.println("Status : " + status);

        //String status = service.updateJobByCompanyName("Java developer", "Infosys");
       // System.out.println("Status : " + status);


      //  String status = service.updateSalaryByJobTitle("Java Developer", 70000.0);
       // System.out.println("Status : " + status);

       // List<String> jobTitles = service.getJobTitles();
        //    System.out.println(jobTitles);

    //    List<Object> companyNames = service.getCompanyNames();
    //    for (Object companyName : companyNames) {
    //        System.out.println(companyName);
     //   }
        List<Object[]> jobs = service.getJobTitleAndCompanyName();
        for (Object[] job : jobs) {
            System.out.println("Job Title: " + job[0]);
            System.out.println("Company Name: " + job[1]);
        }

        List<List<Object>> jobs1= service.getJobTitleAndJobType();
        for (List<Object> job : jobs1) {
            System.out.println("Job Title : " + job.get(0));
            System.out.println("Job Type  : " + job.get(1));
            System.out.println("----------------------");
        }

    }
    }


