package edu.eiu.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Utility class for JPA operations.
 * <ul>
 *   <li>Initializes the database connection using configuration from the persistence unit.</li>
 *   <li>Handles schema generation: loading configuration, dropping, and creating tables as needed.  should be loaded only once at the first time => use SINGLETON.</li>
 *   <li>Provides an EntityManager for managing database interactions.</li>
 * </ul>
 */
public class JpaUtil {
    private static final EntityManagerFactory emf;

    // TIP: Static initializer block, executed when the JpaUtil class is first accessed
    static {
        try {
            emf = Persistence.createEntityManagerFactory("pu1-student-3layer");
        } catch (Exception e) {
            System.err.println("Cannot create EntityManagerFactory: " + e.getMessage());
            throw new RuntimeException("Failed to initialize EntityManagerFactory", e);
        }
    }

    /**
     * To ensure the static block above is executed, all constructors must be disabled.
     * By default, if no constructor is declared, the class inherits the default no-argument constructor from Object.
     */
    private JpaUtil() {
        // Private constructor to prevent instantiation
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
