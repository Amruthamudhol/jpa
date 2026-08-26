package com.xworkz.library.dao.impl;

import com.xworkz.library.Entity.BookEntity;
import com.xworkz.library.dao.BookDAO;

import javax.persistence.*;

public class BookDAOimpl implements BookDAO {
    @Override
    public boolean save(BookEntity entity) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();// TCL
            et.begin();
            em.persist(entity);
            et.commit();

            System.out.println("Data saved successfully: " + entity);

            return true;

        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

            return false;

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