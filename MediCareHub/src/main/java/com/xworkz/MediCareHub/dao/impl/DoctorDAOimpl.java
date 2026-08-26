package com.xworkz.MediCareHub.dao.impl;

import com.xworkz.MediCareHub.dao.DoctorDAO;
import com.xworkz.MediCareHub.entity.DoctorEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
}
