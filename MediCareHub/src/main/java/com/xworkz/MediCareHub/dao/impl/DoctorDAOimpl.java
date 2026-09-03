package com.xworkz.MediCareHub.dao.impl;

import com.xworkz.MediCareHub.dao.DoctorDAO;
import com.xworkz.MediCareHub.entity.DoctorEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class DoctorDAOimpl implements DoctorDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean save(DoctorEntity entity) {
        System.out.println("Invoking save : DoctorDAOimpl");
        EntityManager em = null;
        EntityTransaction et = null;

        try {
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
        EntityManager em = null;
        EntityTransaction et = null;

        try {
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
        }
    }


    @Override
    public DoctorEntity findDoctorEntityById(Integer id) {

        System.out.println("Invoking findDoctorEntityById : DoctorDAOImpl");
        EntityManager em = null;

        try {
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
        }
    }


//getResultList()
    @Override
    public List<DoctorEntity> readAllDoctorEntity() {
        System.out.println("readAllDoctorEntity : DoctorDaoImpl");
        List<DoctorEntity> doctorEntityList = Collections.emptyList();

        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Query query = em.createQuery("select d from DoctorEntity d");
            doctorEntityList = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return doctorEntityList;
    }

//getResultList()
    @Override
    public List<DoctorEntity> getDoctorsBySpecializationAndExperience(String specialization, Integer experience) {

        List<DoctorEntity> entityList = null;
        EntityManager em = null;

        try {

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

        }

        return entityList;
    }

//getResultList();
    @Override
    public List<DoctorEntity> getDoctorsBySpecializationAndEmail(String specialization, String email) {
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
        }

        return entityList;
    }

//getResultList()
    @Override
    public List<DoctorEntity> getDoctorsByExperienceAndSpecialization(Integer experience, String specialization) {

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

        }

        return entityList;
    }


    //getSingleResult()
    @Override
    public DoctorEntity getDoctorByNameAndSpecialization(String doctorName, String specialization) {

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
        }

        return entity;
    }

    @Override
    public Boolean updateDoctorEmailAndPhone(Integer id, String email, Long phoneNumber) {
        System.out.println("Invoking updateDoctorEmailAndPhone : DAO");

        Boolean isUpdated = false;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            Query query = em.createNamedQuery("updateDoctorEmailAndPhone");

            query.setParameter("email", email);
            query.setParameter("phoneNumber", phoneNumber);
            query.setParameter("id", id);

            int rowsUpdated = query.executeUpdate();

            if (rowsUpdated > 0) {
                isUpdated = true;
            }
            et.commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
                et.rollback();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return isUpdated;
    }



    @Override
    public Boolean updateDoctorExperienceByName(String doctorName, Integer experience) {

        System.out.println("Invoking updateDoctorExperienceByName : DAO");
        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            Query query = em.createNamedQuery("updateDoctorExperienceByName");

            query.setParameter("experience", experience);
            query.setParameter("doctorName", doctorName);

            int rowsUpdated = query.executeUpdate();

            if (rowsUpdated > 0) {
                isUpdated = true;
            }

            et.commit();

        } catch (PersistenceException e) {

            e.printStackTrace();

            if (et != null ) {
                et.rollback();
            }

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return isUpdated;
    }
    @Override
    public List<String> getDoctorNames() {

        System.out.println("getDoctorNames : DAO");

        EntityManager em = emf.createEntityManager();

        List<String> names = Collections.emptyList();

        try {

            names = em.createQuery(
                    "select d.doctorName from DoctorEntity d").getResultList();
        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            em.close();
        }

        return names;
    }

    @Override
    public List<Long> getPhoneNumbers() {

        System.out.println("getPhoneNumbers : DAO");
        List<Long> phoneNumbers = Collections.emptyList();

        try {

            phoneNumbers = emf.createEntityManager()
                    .createQuery(
                            "select d.phoneNumber from DoctorEntity d")
                    .getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return phoneNumbers;
    }


    @Override
    public List<Object> getEmails() {

        System.out.println("getEmails : DAO");
        List<Object> emails = Collections.emptyList();

        try {

            emails = emf.createEntityManager()
                    .createQuery("select d.email from DoctorEntity d")
                    .getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return emails;
    }
}
