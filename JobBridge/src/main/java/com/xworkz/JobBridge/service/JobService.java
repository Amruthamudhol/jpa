package com.xworkz.JobBridge.service;

import com.xworkz.JobBridge.dto.JobDTO;

import java.util.List;

public interface JobService {
    boolean validateAndSave(JobDTO dto);

    String saveAll(List<JobDTO> dtoList);
    JobDTO findJobDTOById(Integer id);
    List<JobDTO> readAllJobDTO();
    List<JobDTO> getJobsByCompanyAndLocation(String companyName, String location);
    List<JobDTO> getJobsByTypeAndLocation(String jobType, String location);
    JobDTO getJobByTitleAndCompany(String jobTitle, String companyName);
    JobDTO getJobByCompanyTypeLocation(String companyName, String jobType, String location);
    String updateJobTitleAndCompanyName(Integer id, String jobTitle, String companyName);
    String updateJobByCompanyName(String jobTitle, String companyName);
    String updateSalaryByJobTitle(String jobTitle, Double salary);
    List<String> getJobTitles();
    List<Object> getCompanyNames();
    List<Object[]> getJobTitleAndCompanyName();
    List<List<Object>> getJobTitleAndJobType();

}
