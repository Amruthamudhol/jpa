package com.xworkz.JobBridge.service.impl;

import com.xworkz.JobBridge.dao.JobDAO;
import com.xworkz.JobBridge.dao.impl.JobDAOimpl;
import com.xworkz.JobBridge.dto.JobDTO;
import com.xworkz.JobBridge.entity.JobEntity;
import com.xworkz.JobBridge.service.JobService;

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

}
