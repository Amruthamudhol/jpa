package com.xworkz.JobBridge.dao.impl;

import com.xworkz.JobBridge.dao.JobDAO;
import com.xworkz.JobBridge.entity.JobEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class JobDAOimpl implements JobDAO {
    private  static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean save(JobEntity entity) {
        System.out.println("Invoking save : JobDAOimpl");
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.persist(entity);
            et.commit();
            System.out.println("Job Data Saved");

            return true;

        } catch (Exception e) {

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
    public boolean saveAll(List<JobEntity> entityList) {

        System.out.println("Invoking saveAll : JobDAOimpl");
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            for (JobEntity entity : entityList) {
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
        }
    }



    @Override
    public JobEntity findJobEntityById(Integer id) {

        System.out.println("Invoking findJobEntityById : JobDAOImpl");
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            JobEntity entity = em.find(JobEntity.class, id);

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
    public List<JobEntity> readAllJobEntity() {

        System.out.println("readAllJobEntity : JobDaoImpl");

        List<JobEntity> jobEntityList = Collections.emptyList();
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Query query = em.createQuery("select j from JobEntity j");
            jobEntityList = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return jobEntityList;
    }

//getresult
    @Override
    public List<JobEntity> getJobsByCompanyAndLocation(String companyName, String location) {

        List<JobEntity> entityList = null;
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getJobsByCompanyAndLocation");

            query.setParameter("companyName", companyName);
            query.setParameter("location", location);

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
    public List<JobEntity> getJobsByTypeAndLocation(String jobType, String location) {
        EntityManager em = emf.createEntityManager();

        List<JobEntity> entityList = null;

        try {
            Query query = em.createNamedQuery("getJobsByTypeAndLocation");

            query.setParameter("jobType", jobType);
            query.setParameter("location", location);

            entityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }

        return entityList;
    }

//getSingleResult()
    @Override
    public JobEntity getJobByTitleAndCompany(String jobTitle, String companyName) {
        EntityManager em = emf.createEntityManager();

        JobEntity entity = null;

        try {
            Query query = em.createNamedQuery("getJobByTitleAndCompany");

            query.setParameter("jobTitle", jobTitle);
            query.setParameter("companyName", companyName);

            Object ref = query.getSingleResult();

            entity = (JobEntity) ref;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }

        return entity;
    }

//getSingleResult()
    @Override
    public JobEntity getJobByCompanyTypeLocation(String companyName, String jobType, String location) {
        EntityManager em = emf.createEntityManager();
        JobEntity entity = null;

        try {
            Query query = em.createNamedQuery("getJobByCompanyTypeLocation");
            query.setParameter("companyName", companyName);
            query.setParameter("jobType", jobType);
            query.setParameter("location", location);

            Object ref = query.getSingleResult();

            entity = (JobEntity) ref;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }

        return entity;
    }


    @Override
    public Boolean updateJobTitleAndCompanyName(Integer id, String jobTitle, String companyName) {

        System.out.println("Invoking updateJobTitleAndCompanyName : DAO");
        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            Query query = em.createNamedQuery("updateJobTitleAndCompanyName");

            query.setParameter("jobTitle", jobTitle);
            query.setParameter("companyName", companyName);
            query.setParameter("id", id);

            int rowsUpdated = query.executeUpdate();

            if (rowsUpdated > 0) {
                isUpdated = true;
            }

            et.commit();

        } catch (PersistenceException e) {

            e.printStackTrace();
            if (et != null) {
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
    public Boolean updateJobByCompanyName(String jobTitle, String companyName) {
        System.out.println("Invoking updateJobByCompanyName : DAO");
        Boolean isUpdated = false;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            Query query = em.createNamedQuery("updateJobByCompanyName");

            query.setParameter("companyName", companyName);
            query.setParameter("jobTitle", jobTitle);
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
        public Boolean updateSalaryByJobTitle(String jobTitle, Double salary) {

            System.out.println("Invoking updateSalaryByJobTitle : DAO");
            Boolean isUpdated = false;

            EntityManager em = null;
            EntityTransaction et = null;

            try {
                em = emf.createEntityManager();
                et = em.getTransaction();

                et.begin();

                Query query = em.createNamedQuery("updateSalaryByJobTitle");

                query.setParameter("salary", salary);
                query.setParameter("jobTitle", jobTitle);
                int rowsUpdated = query.executeUpdate();

                System.out.println("Rows Updated : " + rowsUpdated);

                if (rowsUpdated > 0) {
                    isUpdated = true;
                }

                et.commit();

            } catch (PersistenceException e) {

                e.printStackTrace();
                if (et != null) {
                    et.rollback();
                }

            } finally {

                if (em != null) {
                    em.close();
                }
            }

            return isUpdated;
        }

}
