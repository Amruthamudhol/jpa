package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.BookingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadBooking {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {


            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            BookingEntity entity = em.find(BookingEntity.class, 1);
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
