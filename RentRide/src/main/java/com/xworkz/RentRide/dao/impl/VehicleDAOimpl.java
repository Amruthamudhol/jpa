package com.xworkz.RentRide.dao.impl;

import com.xworkz.RentRide.dao.VehicleDAO;
import com.xworkz.RentRide.entity.VehicleEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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

    @Override
    public boolean saveAll(List<VehicleEntity> entityList) {

        System.out.println("Invoking saveAll : VehicleDAOImpl");
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            for (VehicleEntity entity : entityList) {
                em.persist(entity);
            }

            et.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
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
    public VehicleEntity findVehicleEntityById(Integer id) {

        System.out.println("Invoking findVehicleEntityById : VehicleDAOImpl");
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            VehicleEntity entity = em.find(VehicleEntity.class, id);
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
}