package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.FeedbackEntity;

import javax.persistence.*;

public class CreateFeedback {
    public static void main(String[] args) {
        FeedbackEntity entity = new FeedbackEntity();

        entity.setName("Akshay");
        entity.setEmail("akshay@gmail.com");
        entity.setRating(5);
        entity.setMessage("Very good service");

        EntityManagerFactory emf = null;EntityManager em = null;
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

