package edu.eiu.repository;

import edu.eiu.entity.School;
import edu.eiu.infra.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class SchoolRepo {
    public static void save(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(school);
        em.getTransaction().commit();
        em.close();
    }

    public static School findById(String schoolId) {
        EntityManager em = JpaUtil.getEntityManager();
        School school = em.find(School.class, schoolId);
        em.close();
        return school;
    }

    public static List<School> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<School> schools = em.createQuery("SELECT s FROM School s", School.class).getResultList();
        em.close();
        return schools;
    }

    public static List<School> findByName(String schoolName) {
        EntityManager em = JpaUtil.getEntityManager();
        var schools = em.createQuery("SELECT s FROM School s WHERE s.name LIKE :name", School.class)
                .setParameter("name", "%" + schoolName + "%")
                .getResultList();
        em.close();
        return schools;
    }
}
