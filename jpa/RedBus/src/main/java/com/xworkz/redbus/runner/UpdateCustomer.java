package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.CustomerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateCustomer {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            CustomerEntity entity = em.find(CustomerEntity.class, 1);

            System.out.println("Before Update : " + entity);

            if (entity != null) {
                entity.setCustomerName("Hemanth");
                entity.setEmail("hemanth@gmail.com");
                entity.setPhoneNumber(9535018790L);
                entity.setAddress("Bengaluru");

                CustomerEntity updatedEntity = em.merge(entity);

                System.out.println("After Update : " + updatedEntity);

                et.commit();

            } else {

                System.out.println("ID 2 not found");

                et.rollback();
            }

        } catch (Exception e) {

            e.printStackTrace();

            if (et != null && et.isActive()) {
                et.rollback();
            }

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
