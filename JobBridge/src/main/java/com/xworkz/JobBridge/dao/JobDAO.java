package com.xworkz.JobBridge.dao;

import com.xworkz.JobBridge.entity.JobEntity;

import java.util.List;

public interface JobDAO {
    boolean save(JobEntity jobEntity);
    boolean saveAll(List<JobEntity> entityList);
    JobEntity findJobEntityById(Integer id);

    List<JobEntity> readAllJobEntity();
    List<JobEntity> getJobsByCompanyAndLocation(String companyName, String location);
    List<JobEntity> getJobsByTypeAndLocation(String jobType, String location);
    JobEntity getJobByTitleAndCompany(String jobTitle, String companyName);
    JobEntity getJobByCompanyTypeLocation(String companyName, String jobType, String location);
    Boolean updateJobTitleAndCompanyName(Integer id, String jobTitle, String companyName);
    Boolean updateJobByCompanyName(String jobTitle, String companyName);
    Boolean updateSalaryByJobTitle(String jobTitle, Double salary);
}
