package com.xworkz.RentRide.dao.impl;

import com.xworkz.RentRide.dao.VehicleDAO;
import com.xworkz.RentRide.entity.VehicleEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class VehicleDAOimpl implements VehicleDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(VehicleEntity entity) {

        System.out.println("Invoking save : VehicleDAOimpl");
        EntityManager em = null;
        EntityTransaction et = null;

        try {
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

        }
    }

    @Override
    public boolean saveAll(List<VehicleEntity> entityList) {

        System.out.println("Invoking saveAll : VehicleDAOImpl");
        EntityManager em = null;
        EntityTransaction et = null;

        try {
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

        }
    }


    @Override
    public VehicleEntity findVehicleEntityById(Integer id) {

        System.out.println("Invoking findVehicleEntityById : VehicleDAOImpl");
        EntityManager em = null;

        try {
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

        }
    }

//getResultList
    @Override
    public List<VehicleEntity> readAllVehicleEntity() {
        System.out.println("readAllVehicleEntity : VehicleDaoImpl");
        List<VehicleEntity> vehicleEntityList = Collections.emptyList();
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Query query = em.createQuery("select v from VehicleEntity v");
            vehicleEntityList = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

        }

        return vehicleEntityList;
    }

//getSingleResult
    @Override
    public VehicleEntity getVehicleByName(String vehicleName) {
        System.out.println("Invoking findByVehicleName : " + vehicleName);

        VehicleEntity entity = null;
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getVehicleByName");
            query.setParameter("vehicleName", vehicleName);

            entity = (VehicleEntity) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }

        }

        return entity;
    }


//getResultList
    @Override
    public List<VehicleEntity> getVehicleByBrandAndType(String brand, String vehicleType) {

        System.out.println("Invoking getVehicleByBrandAndType");
        EntityManager em = null;
        List<VehicleEntity> entityList = null;

        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getVehicleByBrandAndType");

            query.setParameter("brand", brand);
            query.setParameter("vehicleType", vehicleType);

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



//getSingleResult
    @Override
    public VehicleEntity getVehicleByModel(String model, Integer id) {

        System.out.println("Invoking getVehicleByModel : " + model + ", " + id);
        VehicleEntity entity = null;
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getVehicleByModel");

            query.setParameter("model", model);
            query.setParameter("id", id);

            Object ref = query.getSingleResult();
            entity = (VehicleEntity) ref;

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

        }

        return entity;
    }


    //getResultList()

    @Override
    public List<VehicleEntity> getVehicleByBrandAndModel(String brand, String model) {

        System.out.println("Invoking getVehicleByBrandAndModel : " + brand + ", " + model);

        List<VehicleEntity> entityList = null;
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getVehicleByBrandAndModel");

            query.setParameter("brand", brand);
            query.setParameter("model", model);
            entityList = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

        }

        return entityList;
    }



    @Override
    public Boolean updateBrandAndModelByVehicleName(String vehicleName, String brand, String model) {

        System.out.println("Invoking updateBrandAndModelByVehicleName : " + vehicleName);
        Boolean isUpdated = false;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            Query query = em.createQuery("UPDATE VehicleEntity v " + "SET v.brand = :brand, " + "v.model = :model " + "WHERE v.vehicleName = :vehicleName");
            query.setParameter("brand", brand);
            query.setParameter("model", model);
            query.setParameter("vehicleName", vehicleName);

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



//update
    @Override
    public Boolean updateVehicleName(Integer id, String vehicleName) {
        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            Query query = em.createNamedQuery("updateVehicleName");
            query.setParameter("vehicleName", vehicleName);
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
    public Boolean updateVehicleType(Integer id, String vehicleType) {

        System.out.println("Invoking updateVehicleType : DAO");
        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            Query query = em.createNamedQuery("updateVehicleType");
            query.setParameter("vehicleType", vehicleType);
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
}