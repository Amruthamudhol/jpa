package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.PaymentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdatePayment {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            PaymentEntity entity = em.find(PaymentEntity.class, 1);
            System.out.println("Before Update : " + entity);

            if (entity != null) {

                entity.setBookingId(102);
                entity.setName("Akshata");
                entity.setEmail("akshata@gmail.com");
                entity.setAmount(750.0);
                entity.setPaymentMethod("UPI");
                entity.setPaymentStatus("SUCCESS");
                entity.setTransactionId("TXN102345");
                entity.setPaymentDate("2026-08-24");

                PaymentEntity updatedEntity = em.merge(entity);

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
