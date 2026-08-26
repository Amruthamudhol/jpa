package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.BookingEntity;

import javax.persistence.*;

public class CreateBooking {
    public static void main(String[] args) {

        BookingEntity entity = new BookingEntity();

        entity.setName("Akshay");
        entity.setEmail("akshay@gmail.com");
        entity.setPhoneNumber(9632336136L);
        entity.setBookingDate("23-08-2026");
        entity.setNumberOfPeople(3);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("redbus");// load, connect

            em = emf.createEntityManager();// DML, DQL

            et = em.getTransaction();// TCL

            et.begin();// begin transaction

            em.persist(entity);// insert

            et.commit();// commit transaction

            System.out.println("Data saved successfully: " + entity);

        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
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


