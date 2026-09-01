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


//getResultList()
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

//getResultList()
    @Override
    public List<DoctorEntity> getDoctorsBySpecializationAndExperience(String specialization, Integer experience) {

        List<DoctorEntity> entityList = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getDoctorsBySpecializationAndExperience");

            query.setParameter("specialization", specialization);
            query.setParameter("experience", experience);

            entityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return entityList;
    }

//getResultList();
    @Override
    public List<DoctorEntity> getDoctorsBySpecializationAndEmail(String specialization, String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = emf.createEntityManager();

        List<DoctorEntity> entityList = null;

        try {

            Query query = em.createNamedQuery("getDoctorsBySpecializationAndEmail");

            query.setParameter("specialization", specialization);
            query.setParameter("email", email);

            entityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            em.close();
            emf.close();
        }

        return entityList;
    }

//getResultList()
    @Override
    public List<DoctorEntity> getDoctorsByExperienceAndSpecialization(Integer experience, String specialization) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = emf.createEntityManager();
        List<DoctorEntity> entityList = null;

        try {

            Query query = em.createNamedQuery("getDoctorsByExperienceAndSpecialization");

            query.setParameter("experience", experience);
            query.setParameter("specialization", specialization);

            entityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            em.close();
            emf.close();
        }

        return entityList;
    }


    //getSingleResult()
    @Override
    public DoctorEntity getDoctorByNameAndSpecialization(String doctorName, String specialization) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = emf.createEntityManager();

        DoctorEntity entity = null;

        try {

            Query query = em.createNamedQuery("getDoctorByNameAndSpecialization");

            query.setParameter("doctorName", doctorName);
            query.setParameter("specialization", specialization);

            Object ref = query.getSingleResult();

            entity = (DoctorEntity) ref;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            em.close();
            emf.close();
        }

        return entity;
    }
}
