package com.xworkz.library.dao.impl;

import com.xworkz.library.Entity.BookEntity;
import com.xworkz.library.dao.BookDAO;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class BookDAOimpl implements BookDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(BookEntity entity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
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
        }
    }



    @Override
    public boolean saveAll(List<BookEntity> entityList) {

        System.out.println("Invoking saveAll : BookDAOImpl");
        EntityManager em = null;
        EntityTransaction et = null;

        try {
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

        }
    }



    @Override
    public BookEntity findBookEntityById(Integer id) {

        System.out.println("Invoking findBookEntityById : BookDAOImpl");
        EntityManager em = null;

        try {
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
        }
    }

//getresult

    @Override
    public List<BookEntity> readAllBookEntity() {

        System.out.println("readAllBookEntity : BookDaoImpl");
        List<BookEntity> bookEntityList = Collections.emptyList();
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("select b from BookEntity b");

            bookEntityList = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

        }

        return bookEntityList;
    }

//getresult
    @Override
    public List<BookEntity> getBooksByAuthorAndCategory(String author, String category) {

        List<BookEntity> entityList = null;
        EntityManager em = null;

        try {
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

        }

        return entityList;
    }


    //getresultlist
    @Override
    public List<BookEntity> getBooksByCategoryAndPrice(String category, Double price) {

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
        }

        return entityList;
    }

    @Override
    public BookEntity getBookByTitleAndAuthor(String title, String author) {
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
        }

        return entity;
    }


    @Override
    public Boolean updateBookPriceByTitle(String title, Double price) {

        System.out.println("Invoking updateBookPriceByTitle : DAO");
        Boolean isUpdated = false;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            Query query = em.createNamedQuery("updateBookPriceByTitle");
            query.setParameter("price", price);
            query.setParameter("title", title);

            int rowsUpdated = query.executeUpdate();

            System.out.println("Rows Updated : " + rowsUpdated);

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
    public Boolean updateBookQuantityByAuthor(String author, Integer quantity) {

        System.out.println("Invoking updateBookQuantityByAuthor : DAO");
        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            Query query = em.createNamedQuery("updateBookQuantityByAuthor");

            query.setParameter("quantity", quantity);
            query.setParameter("author", author);

            int rowsUpdated = query.executeUpdate();

            System.out.println("Rows Updated : " + rowsUpdated);

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
    public List<String> getAuthors() {
        System.out.println("getAuthors : DAO");
        List<String> authors = Collections.emptyList();

        try {

            authors = emf.createEntityManager()
                    .createQuery("select b.author from BookEntity b")
                    .getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return authors;
    }


    @Override
    public List<Object> getCategories() {

        System.out.println("getCategories : DAO");
        List<Object> categories = Collections.emptyList();

        try {

            categories = emf.createEntityManager()
                    .createQuery("select b.category from BookEntity b")
                    .getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return categories;
    }
}