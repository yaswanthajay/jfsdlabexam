package com.klef.jfsd.exam;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the configuration file explicitly
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            
            // Build the SessionFactory
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("SessionFactory created successfully.");
        } catch (Exception ex) {
            // Log the exception
            System.err.println("Initial SessionFactory creation failed.");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Provide the SessionFactory instance
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            throw new IllegalStateException("SessionFactory was not initialized.");
        }
        return sessionFactory;
    }

    // Add a shutdown method to clean up resources
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
