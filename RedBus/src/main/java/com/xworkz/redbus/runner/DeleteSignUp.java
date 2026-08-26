package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.*;

public class DeleteSignUp {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            et = em.getTransaction();

            SignUpEntity entity = em.find(SignUpEntity.class, 2);

            if (entity != null) {
                et.begin();
                em.remove(entity);

                System.out.println("Data Deleted from database");
                et.commit();

            } else {

                System.out.println("Data Not Found in database");
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
                et.rollback();

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
