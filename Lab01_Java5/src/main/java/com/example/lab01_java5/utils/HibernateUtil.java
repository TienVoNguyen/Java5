package com.example.lab01_java5.utils;

import com.example.lab01_java5.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/lap01_java5");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "Vo13213455");
        properties.put(Environment.SHOW_SQL, "true");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        FACTORY = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
