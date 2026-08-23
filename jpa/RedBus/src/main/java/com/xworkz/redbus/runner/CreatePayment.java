package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.PaymentEntity;

import javax.persistence.*;

public class CreatePayment {
    public static void main(String[] args) {
        PaymentEntity entity = new PaymentEntity();

        entity.setBookingId(101);
        entity.setName("Akshay");
        entity.setEmail("akshay@gmail.com");
        entity.setAmount(850.00);
        entity.setPaymentMethod("UPI");
        entity.setPaymentStatus("SUCCESS");
        entity.setTransactionId("TXN123456789");
        entity.setPaymentDate("23-08-2026");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("redbus");// load, connect

            em = emf.createEntityManager();// DML, DQL

            et = em.getTransaction();// TCL

            et.begin();// begin transaction

            em.persist(entity);// insert

            et.commit();// commit transaction

            System.out.println("Data saved successfully: " + entity);

        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close(); }

            if (emf != null) {
                emf.close();
            }
        }
    }

}
