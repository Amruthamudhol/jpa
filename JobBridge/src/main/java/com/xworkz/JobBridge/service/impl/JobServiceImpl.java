package com.xworkz.JobBridge.service.impl;

import com.xworkz.JobBridge.dao.JobDAO;
import com.xworkz.JobBridge.dao.impl.JobDAOimpl;
import com.xworkz.JobBridge.dto.JobDTO;
import com.xworkz.JobBridge.entity.JobEntity;
import com.xworkz.JobBridge.service.JobService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JobServiceImpl implements JobService {
    JobDAO jobDAO = new JobDAOimpl();

    @Override
    public boolean validateAndSave(JobDTO dto) {

        System.out.println("Invoking validateAndSave : JobServiceImpl");
        boolean isSaved = false;

        if (dto != null) {
            JobEntity entity = new JobEntity();

            entity.setJobTitle(dto.getJobTitle());
            entity.setCompanyName(dto.getCompanyName());
            entity.setLocation(dto.getLocation());
            entity.setJobType(dto.getJobType());
            entity.setSalary(dto.getSalary());

            boolean saved = jobDAO.save(entity);

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
    public String saveAll(List<JobDTO> dtoList) {
        System.out.println("Invoking saveAll : JobServiceImpl");
        String isSaved = null;

        if (dtoList != null ) {
            System.out.println("List of DTO : " + dtoList);
            List<JobEntity> entityList = new ArrayList<>();

            for (JobDTO dto : dtoList) {
                JobEntity entity = new JobEntity();
                entity.setJobTitle(dto.getJobTitle());
                entity.setCompanyName(dto.getCompanyName());
                entity.setLocation(dto.getLocation());
                entity.setJobType(dto.getJobType());
                entity.setSalary(dto.getSalary());
                entityList.add(entity);
            }
            boolean status = jobDAO.saveAll(entityList);

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
    public JobDTO findJobDTOById(Integer id) {
        System.out.println("Invoking findJobDTOById : JobServiceImpl");
        JobEntity entity = jobDAO.findJobEntityById(id);
        if (entity != null) {

            JobDTO dto = new JobDTO();

            dto.setJobTitle(entity.getJobTitle());
            dto.setCompanyName(entity.getCompanyName());
            dto.setLocation(entity.getLocation());
            dto.setJobType(entity.getJobType());
            dto.setSalary(entity.getSalary());

            return dto;
        }

        return null;
    }



    @Override
    public List<JobDTO> readAllJobDTO() {
        System.out.println("readAllJobDTO : JobServiceImpl");
        List<JobEntity> entityList = jobDAO.readAllJobEntity();

        List<JobDTO> dtoList = entityList.stream()
                .map(entity -> new JobDTO(
                        entity.getJobTitle(),
                        entity.getCompanyName(),
                        entity.getLocation(),
                        entity.getJobType(),
                        entity.getSalary()
                ))
                .collect(Collectors.toList());

        return dtoList;
    }


    @Override
    public List<JobDTO> getJobsByCompanyAndLocation(String companyName, String location) {

        List<JobDTO> dtoList = new ArrayList<>();
        List<JobEntity> entityList = jobDAO.getJobsByCompanyAndLocation(companyName, location);

        for (JobEntity entity : entityList) {

            JobDTO dto = new JobDTO();

            dto.setJobTitle(entity.getJobTitle());
            dto.setCompanyName(entity.getCompanyName());
            dto.setLocation(entity.getLocation());
            dto.setJobType(entity.getJobType());
            dto.setSalary(entity.getSalary());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<JobDTO> getJobsByTypeAndLocation(String jobType, String location) {

        List<JobDTO> dtoList = new ArrayList<>();
        List<JobEntity> entityList = jobDAO.getJobsByTypeAndLocation(jobType, location);
        for (JobEntity entity : entityList) {

            JobDTO dto = new JobDTO();

            dto.setJobTitle(entity.getJobTitle());
            dto.setCompanyName(entity.getCompanyName());
            dto.setLocation(entity.getLocation());
            dto.setJobType(entity.getJobType());
            dto.setSalary(entity.getSalary());

            dtoList.add(dto);
        }

        return dtoList;
    }



    @Override
    public JobDTO getJobByTitleAndCompany(String jobTitle, String companyName) {

        JobEntity entity = jobDAO.getJobByTitleAndCompany(jobTitle, companyName);
        JobDTO dto = null;

        if (entity != null) {

            dto = new JobDTO();

            dto.setJobTitle(entity.getJobTitle());
            dto.setCompanyName(entity.getCompanyName());
            dto.setLocation(entity.getLocation());
            dto.setJobType(entity.getJobType());
            dto.setSalary(entity.getSalary());
        }

        return dto;
    }


    @Override
    public JobDTO getJobByCompanyTypeLocation(String companyName, String jobType, String location) {

        JobEntity entity = jobDAO.getJobByCompanyTypeLocation(companyName, jobType, location);

        JobDTO dto = null;

        if (entity != null) {

            dto = new JobDTO();

            dto.setJobTitle(entity.getJobTitle());
            dto.setCompanyName(entity.getCompanyName());
            dto.setLocation(entity.getLocation());
            dto.setJobType(entity.getJobType());
            dto.setSalary(entity.getSalary());
        }

        return dto;
    }


    @Override
    public String updateJobTitleAndCompanyName(Integer id, String jobTitle, String companyName) {

        System.out.println("Invoking updateJobTitleAndCompanyName : Service");

        String status = null;

        if (id != null && id > 0 && jobTitle != null && companyName != null) {
            Boolean isUpdated = jobDAO.updateJobTitleAndCompanyName(id, jobTitle, companyName);

            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }


    @Override
    public String updateJobByCompanyName(String jobTitle, String companyName) {

        System.out.println("Invoking updateJobByCompanyName : Service");
        String status = null;

        if (jobTitle != null && companyName != null) {
            Boolean isUpdated = jobDAO.updateJobByCompanyName(jobTitle, companyName);

            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }

    @Override
    public String updateSalaryByJobTitle(String jobTitle, Double salary) {
        System.out.println("Invoking updateSalaryByJobTitle : Service");

        String status = null;

        if (jobTitle != null && salary != null) {

            Boolean isUpdated = jobDAO.updateSalaryByJobTitle(jobTitle, salary);
            if (isUpdated) {
                status = "Data Updated";
            } else {
                status = "Data Not Updated";
            }
        }

        return status;
    }

    @Override
    public List<String> getJobTitles() {
        System.out.println("getJobTitles : Service");
        List<String> jobTitles = jobDAO.getJobTitles();

        if (jobTitles != null) {
            return jobTitles;
        }

        return Collections.emptyList();
    }

    @Override
    public List<Object> getCompanyNames() {
        System.out.println("getCompanyNames : Service");
        List<Object> companyNames = jobDAO.getCompanyNames();

        if (companyNames != null) {
            return companyNames;
        }

        return Collections.emptyList();
    }
}
