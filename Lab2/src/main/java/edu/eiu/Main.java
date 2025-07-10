package edu.eiu;

import edu.eiu.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");
    public static void main(String[] args) {
//        insertStudent();
//        getStudentById("CSEID12345");
//        getAllStudents();
//        getStudentsByGpa();

//        updateStudentById("CSEID12345", "John Smith", 2001, 3.8);
//        deleteStudentById("CSEID12345");
//        getStudentByCondition("HN", 3.5);
    }

    public static void insertStudent() {
        EntityManager em = emf.createEntityManager();
        Student student = new Student("CSEID12345", "John Doe", 2000, 3.5);
        Student student1 = new Student("CSEID12346", "Steven", 2000, 3.7);
        Student student2 = new Student("CSEID12347", "HN", 2000, 4.0);
        em.getTransaction().begin();
        em.persist(student);
        em.persist(student1);//ghi xuong database nhưng chưa thực hiện
        em.persist(student2);
        em.getTransaction().commit(); //thực hiện ghi xuống database
        em.close();
    }

    public static void getStudentById(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        System.out.println("Student found with ID: " + student.toString());
        em.getTransaction().commit();
        em.close();
    }

    public static void getAllStudents() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        var students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        System.out.println("All students in the database:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void getStudentsByGpa() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        var students = em.createQuery("SELECT s FROM Student s WHERE s.gpa > 3.6", Student.class).getResultList();
        System.out.println("All students in the database:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void updateStudentById(String id, String name, int yob, double gpa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            student.setName(name);
            student.setYob(yob);
            student.setGpa(gpa);
            em.merge(student); // Update the student entity
        } else {
            System.out.println("Student not found with ID: " + id);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteStudentById(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student); // Remove the student entity
            System.out.println("Student with ID: " + id + " has been deleted.");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void getStudentByCondition(String name, Double gpa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String query = "SELECT s FROM Student s WHERE s.name = :name AND s.gpa > :gpa";
        var students = em.createQuery(query, Student.class)
                         .setParameter("name", name)
                         .setParameter("gpa", gpa)
                         .getResultList();
        System.out.println("Students found with name: " + name + " and GPA greater than: " + gpa);
        for (Student student : students) {
            System.out.println(student.toString());
        }
        em.getTransaction().commit();
        em.close();
    }
}