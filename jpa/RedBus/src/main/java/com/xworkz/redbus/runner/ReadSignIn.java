package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.SignInEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadSignIn {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            // Create EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();

            SignInEntity entity = em.find(SignInEntity.class, 1);
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
