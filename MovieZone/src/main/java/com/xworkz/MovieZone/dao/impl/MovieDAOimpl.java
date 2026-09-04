package com.xworkz.MovieZone.dao.impl;

import com.xworkz.MovieZone.dao.MovieDAO;
import com.xworkz.MovieZone.entity.MovieEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieDAOimpl implements MovieDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(MovieEntity entity) {
        EntityManager em = null;

        try {
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

        }
    }

    @Override
    public boolean saveAll(List<MovieEntity> entityList) {
        System.out.println("Invoking saveAll : MovieDAOImpl");
        EntityManager em = null;
        EntityTransaction et = null;

        try {
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
            if (et != null ) {
                et.rollback();
            }

            return false;

        } finally {

            if (em != null) {
                em.close();
            }

        }
    }



    @Override
    public MovieEntity findMovieEntityById(Integer id) {

        System.out.println("Invoking findMovieEntityById : MovieDAOImpl");
        EntityManager em = null;

        try {
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
        }
    }


//getResultList()
    @Override
    public List<MovieEntity> readAllMovieEntity() {
        System.out.println("readAllMovieEntity : MovieDaoImpl");
        List<MovieEntity> movieEntityList = Collections.emptyList();
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Query query = em.createQuery("select m from MovieEntity m");
            movieEntityList = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return movieEntityList;
    }


    //getResultList()
    @Override
    public List<MovieEntity> getMoviesByDirectorAndGenre(String director, String genre) {

        List<MovieEntity> entityList = null;
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getMoviesByDirectorAndGenre");
            query.setParameter("director", director);
            query.setParameter("genre", genre);

            entityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return entityList;
    }

//getResultList()
    @Override
    public List<MovieEntity> getMoviesByGenreAndLanguage(String genre, String language) {

        EntityManager em = emf.createEntityManager();

        List<MovieEntity> entityList = null;

        try {

            Query query = em.createNamedQuery("getMoviesByGenreAndLanguage");
            query.setParameter("genre", genre);
            query.setParameter("language", language);

            entityList = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            em.close();
        }

        return entityList;
    }


//getSingleResult();
    @Override
    public MovieEntity getMovieByTitleAndLanguage(String title, String language) {

        EntityManager em = emf.createEntityManager();
        MovieEntity entity = null;

        try {

            Query query = em.createNamedQuery("getMovieByTitleAndLanguage");
            query.setParameter("title", title);
            query.setParameter("language", language);
            Object ref = query.getSingleResult();
            entity = (MovieEntity) ref;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            em.close();
        }

        return entity;
    }


    @Override
    public MovieEntity getMovieByDirectorAndTitle(String director, String title) {
        EntityManager em = emf.createEntityManager();

        MovieEntity entity = null;

        try {

            Query query = em.createNamedQuery("getMovieByDirectorAndTitle");
            query.setParameter("director", director);
            query.setParameter("title", title);

            Object ref = query.getSingleResult();
            entity = (MovieEntity) ref;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            em.close();
        }

        return entity;
    }



    @Override
    public Boolean updateMovieGenreAndRatingByTitle(String title, String genre, Double rating) {

        System.out.println("Invoking updateMovieGenreAndRatingByTitle : DAO");

        Boolean isUpdated = false;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            Query query = em.createNamedQuery("updateMovieGenreAndRatingByTitle");
            query.setParameter("genre", genre);
            query.setParameter("rating", rating);
            query.setParameter("title", title);

            int rowsUpdated = query.executeUpdate();

            if (rowsUpdated > 0) {
                isUpdated = true;
            }

            et.commit();

        } catch (PersistenceException e) {

            e.printStackTrace();
                et.rollback();
        } finally {

            if (em != null) {
                em.close();
            }
        }

        return isUpdated;
    }


    @Override
    public Boolean updateMovieLanguageAndRatingByDirector(String director, String language, Double rating) {

        System.out.println("Invoking updateMovieLanguageAndRatingByDirector : DAO");

        EntityManager em = null;
        EntityTransaction et = null;
        Boolean isUpdated = false;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("updateMovieLanguageAndRatingByDirector");
            query.setParameter("director", director);
            query.setParameter("language", language);
            query.setParameter("rating", rating);

            int rowsUpdated = query.executeUpdate();

            if (rowsUpdated > 0) {
                isUpdated = true;
            }

            et.commit();

        } catch (PersistenceException e) {
            e.printStackTrace();

            if (et != null ) {
                et.rollback();
            }

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return isUpdated;
    }


    @Override
    public List<String> getTitles() {
        System.out.println("getTitles : DAO");
        List<String> titles = Collections.emptyList();

        try {

            titles = emf.createEntityManager()
                    .createQuery("select m.title from MovieEntity m")
                    .getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return titles;
    }


    @Override
    public List<Object> getLanguages() {
        System.out.println("getLanguages : DAO");
        List<Object> languages = Collections.emptyList();

        try {
            languages = emf.createEntityManager()
                    .createQuery("select m.language from MovieEntity m")
                    .getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return languages;
    }


    @Override
    public List<Object[]> getTitleDirectorAndGenre() {
        System.out.println("getTitleDirectorAndGenre : DAO");
        List<Object[]> movies = Collections.emptyList();

        try {

            movies = emf.createEntityManager()
                    .createQuery("select m.title, m.director, m.genre from MovieEntity m")
                    .getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return movies;
    }


    @Override
    public List<List<Object>> getTitleAndLanguage() {
        System.out.println("getTitleAndLanguage : DAO");
        List<List<Object>> movies = new ArrayList<>();

        try {

            List<Object[]> result = emf.createEntityManager()
                    .createQuery("select m.title, m.language from MovieEntity m")
                    .getResultList();

            for (Object[] movie : result) {
                movies.add(Arrays.asList(movie));
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return movies;
    }
}
