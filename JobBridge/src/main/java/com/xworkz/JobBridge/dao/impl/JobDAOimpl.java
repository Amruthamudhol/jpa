package com.xworkz.JobBridge.dao.impl;

import com.xworkz.JobBridge.dao.JobDAO;
import com.xworkz.JobBridge.entity.JobEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JobDAOimpl implements JobDAO {

    @Override
    public boolean save(JobEntity entity) {
        System.out.println("Invoking save : JobDAOimpl");
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

            System.out.println("Job Data Saved");

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
