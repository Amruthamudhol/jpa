package com.xworkz.MovieZone.dao.impl;

import com.xworkz.MovieZone.dao.MovieDAO;
import com.xworkz.MovieZone.entity.MovieEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieDAOimpl implements MovieDAO {
    @Override
    public boolean save(MovieEntity entity) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();

            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();

            System.out.println("Movie saved successfully");
            System.out.println(entity);

            return true;

        } catch (Exception e) {

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
