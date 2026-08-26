package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.SignInEntity;

import javax.persistence.*;

public class CreateSignIn {
    public static void main(String[] args) {
        SignInEntity entity = new SignInEntity();

        entity.setEmail("akshay@gmail.com");
        entity.setPassword("Akshay@123");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("redbus");//load,connect
            em = emf.createEntityManager();//DML,DQL
            et = em.getTransaction();//tcl

            et.begin();//set auto commit

            em.persist(entity);//insert

            et.commit();

            System.out.println("Data saved successfully: " + entity);
        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
                e.getMessage();
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
