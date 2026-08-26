package com.xworkz.JobBridge;

import com.xworkz.JobBridge.dto.JobDTO;
import com.xworkz.JobBridge.service.JobService;
import com.xworkz.JobBridge.service.impl.JobServiceImpl;

public class JobRunner {
    public static void main(String[] args) {

        JobDTO dto = new JobDTO("Java Developer", "Infosys", "Bangalore", "Full Time", 60000.0);
        JobService service = new JobServiceImpl();
        boolean isSaved = service.validateAndSave(dto);
    }
}
