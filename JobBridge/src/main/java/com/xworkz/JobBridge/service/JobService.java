package com.xworkz.JobBridge.service;

import com.xworkz.JobBridge.dto.JobDTO;

public interface JobService {
    boolean validateAndSave(JobDTO dto);

}
