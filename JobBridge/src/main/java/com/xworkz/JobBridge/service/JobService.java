package com.xworkz.JobBridge.service;

import com.xworkz.JobBridge.dto.JobDTO;

import java.util.List;

public interface JobService {
    boolean validateAndSave(JobDTO dto);

    String saveAll(List<JobDTO> dtoList);
    JobDTO findJobDTOById(Integer id);
    List<JobDTO> readAllJobDTO();

}
