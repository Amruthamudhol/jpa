package com.xworkz.MediCareHub.dao.impl;

import com.xworkz.MediCareHub.dao.DoctorDAO;
import com.xworkz.MediCareHub.entity.DoctorEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class DoctorDAOimpl implements DoctorDAO {

    @Override
    public boolean save(DoctorEntity entity) {

        System.out.println("Invoking save : DoctorDAOimpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.persist(entity);

            et.commit();

            System.out.println("Doctor Data Saved");

            return true;

        } catch (Exception e) {

            if (et != null && et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

            return false;

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }
    }


    @Override
    public boolean saveAll(List<DoctorEntity> entityList) {

        System.out.println("Invoking saveAll : DoctorDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            for (DoctorEntity entity : entityList) {
                em.persist(entity);
            }
            et.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

            if (et != null ) {
                et.rollback();
            }

            return false;

        } finally {

            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }


    @Override
    public DoctorEntity findDoctorEntityById(Integer id) {

        System.out.println("Invoking findDoctorEntityById : DoctorDAOImpl");
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();

            DoctorEntity entity = em.find(DoctorEntity.class, id);
            return entity;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }



    @Override
    public List<DoctorEntity> readAllDoctorEntity() {
        System.out.println("readAllDoctorEntity : DoctorDaoImpl");
        List<DoctorEntity> doctorEntityList = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();

            Query query = em.createQuery("select d from DoctorEntity d");
            doctorEntityList = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }

        return doctorEntityList;
    }
}
