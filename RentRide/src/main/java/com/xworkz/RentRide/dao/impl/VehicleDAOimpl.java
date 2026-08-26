package com.xworkz.RentRide.dao.impl;

import com.xworkz.RentRide.dao.VehicleDAO;
import com.xworkz.RentRide.entity.VehicleEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class VehicleDAOimpl implements VehicleDAO {

    @Override
    public boolean save(VehicleEntity entity) {

        System.out.println("Invoking save : VehicleDAOimpl");
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

            System.out.println("Vehicle Data Saved");
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