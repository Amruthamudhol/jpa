package com.xworkz.JobBridge.dao;

import com.xworkz.JobBridge.entity.JobEntity;

import java.util.List;

public interface JobDAO {
    boolean save(JobEntity jobEntity);
    boolean saveAll(List<JobEntity> entityList);
    JobEntity findJobEntityById(Integer id);
}
