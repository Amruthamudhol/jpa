package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.PaymentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadPayment {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            PaymentEntity entity = em.find(PaymentEntity.class, 1);

            System.out.println(entity);

        } catch (Exception e) {

            System.out.println(e.getMessage());

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

