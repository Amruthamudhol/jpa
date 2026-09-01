package com.xworkz.library.dao.impl;

import com.xworkz.library.Entity.BookEntity;
import com.xworkz.library.dao.BookDAO;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

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



    @Override
    public boolean saveAll(List<BookEntity> entityList) {

        System.out.println("Invoking saveAll : BookDAOImpl");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            for (BookEntity entity : entityList) {

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

            if (emf != null) {
                emf.close();
            }
        }
    }



    @Override
    public BookEntity findBookEntityById(Integer id) {

        System.out.println("Invoking findBookEntityById : BookDAOImpl");
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            BookEntity entity = em.find(BookEntity.class, id);
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

//getresult

    @Override
    public List<BookEntity> readAllBookEntity() {

        System.out.println("readAllBookEntity : BookDaoImpl");
        List<BookEntity> bookEntityList = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            Query query = em.createQuery("select b from BookEntity b");

            bookEntityList = query.getResultList();

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

        return bookEntityList;
    }

//getresult
    @Override
    public List<BookEntity> getBooksByAuthorAndCategory(String author, String category) {

        List<BookEntity> entityList = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getBooksByAuthorAndCategory");
            query.setParameter("author", author);
            query.setParameter("category", category);

            entityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return entityList;
    }


    //getresultlist
    @Override
    public List<BookEntity> getBooksByCategoryAndPrice(String category, Double price) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = emf.createEntityManager();
        List<BookEntity> entityList = null;

        try {

            Query query = em.createNamedQuery("getBooksByCategoryAndPrice");

            query.setParameter("category", category);
            query.setParameter("price", price);

            entityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            em.close();
            emf.close();
        }

        return entityList;
    }

    @Override
    public BookEntity getBookByTitleAndAuthor(String title, String author) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = emf.createEntityManager();
        BookEntity entity = null;

        try {

            Query query = em.createNamedQuery("getBookByTitleAndAuthor");

            query.setParameter("title", title);
            query.setParameter("author", author);

            Object ref = query.getSingleResult();

            entity = (BookEntity) ref;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            em.close();
            emf.close();
        }

        return entity;
    }
}