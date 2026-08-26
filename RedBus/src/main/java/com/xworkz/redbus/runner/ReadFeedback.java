package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.FeedbackEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadFeedback {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            FeedbackEntity entity = em.find(FeedbackEntity.class, 1);

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
