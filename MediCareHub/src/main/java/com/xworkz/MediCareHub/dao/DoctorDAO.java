package com.xworkz.MediCareHub.dao;

import com.xworkz.MediCareHub.entity.DoctorEntity;

import java.util.List;

public interface DoctorDAO {
    boolean save(DoctorEntity entity);
    boolean saveAll(List<DoctorEntity> entityList);
    DoctorEntity findDoctorEntityById(Integer id);
}
