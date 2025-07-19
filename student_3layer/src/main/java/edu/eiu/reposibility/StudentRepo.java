package edu.eiu.reposibility;


import edu.eiu.entity.Student;
import edu.eiu.infra.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 * Data Flow:
 * Database --(JpaUtil)--> Repository --(Service)--> UI (Main)
 * <p>
 * In the repository, CRUD operations provided by JpaUtil are performed on the database.
 * Common method names are concise verbs such as:
 * <ol>
 *   <li>Insert: save()</li>
 *   <li>Update: update()</li>
 *   <li>Delete: remove()</li>
 *   <li>Select: find(), findAll(), findById(), findByName(), ...</li>
 * </ol>
 */
public class StudentRepo {
    /**
     * <li>Add a new student to the database (wrapped in a transaction to ensure ACID properties).</li>
     */
    public static void save(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * <li>Update an existing student's information (transactional).</li>
     */
    public static void update(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        // if student is existing, it will be updated; if not, it will be inserted.
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * <li>Delete a student by ID or by passing the student object.</li>
     */
    public static void remove(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * <li>Find students by ID, by name, or retrieve all students.</li>
     */
    public static Student findById(String studentId) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = em.find(Student.class, studentId);
        em.close();
        return student;
    }

    public static List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        em.close();
        return students;
    }

    public static List<Student> findByName(String studentName) {
        EntityManager em = JpaUtil.getEntityManager();
        var students = em.createQuery("SELECT Student FROM Student s WHERE s.fullName LIKE :fullName", Student.class)
                .setParameter("fullName", "%" + studentName + "%")
                .getResultList();
        em.close();
        return students;
    }
}
