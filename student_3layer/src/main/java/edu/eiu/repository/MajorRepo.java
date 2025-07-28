package edu.eiu.repository;

import edu.eiu.entity.Major;
import edu.eiu.infra.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class MajorRepo {
    public static void save(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(major);
        em.getTransaction().commit();
        em.close();
    }

    public static Major findById(String majorId) {
        EntityManager em = JpaUtil.getEntityManager();
        Major major = em.find(Major.class, majorId);
        em.close();
        return major;
    }

    public static List<Major> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Major> majors = em.createQuery("SELECT m FROM Major m", Major.class).getResultList();
        em.close();
        return majors;
    }

    public static List<Major> findByName(String majorName) {
        EntityManager em = JpaUtil.getEntityManager();
        var majors = em.createQuery("SELECT m FROM Major m WHERE m.name LIKE :name", Major.class)
                .setParameter("name", "%" + majorName + "%")
                .getResultList();
        em.close();
        return majors;
    }
}
