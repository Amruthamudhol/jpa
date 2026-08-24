package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadSignup {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            // Create EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();

            SignUpEntity entity = em.find(SignUpEntity.class, 1);
            System.out.println(entity);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
    }

}
