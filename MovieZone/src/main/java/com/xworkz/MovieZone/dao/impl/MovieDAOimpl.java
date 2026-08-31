package com.xworkz.MovieZone.dao.impl;

import com.xworkz.MovieZone.dao.MovieDAO;
import com.xworkz.MovieZone.entity.MovieEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

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

    @Override
    public boolean saveAll(List<MovieEntity> entityList) {
        System.out.println("Invoking saveAll : MovieDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            for (MovieEntity entity : entityList) {

                em.persist(entity);
            }

            et.commit();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            if (et != null && et.isActive()) {
                et.rollback();
            }

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



    @Override
    public MovieEntity findMovieEntityById(Integer id) {

        System.out.println("Invoking findMovieEntityById : MovieDAOImpl");
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            MovieEntity entity = em.find(MovieEntity.class, id);

            return entity;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }
    }



    @Override
    public List<MovieEntity> readAllMovieEntity() {
        System.out.println("readAllMovieEntity : MovieDaoImpl");
        List<MovieEntity> movieEntityList = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();

            Query query = em.createQuery("select m from MovieEntity m");
            movieEntityList = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();

        } finally {
            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return movieEntityList;
    }
}
