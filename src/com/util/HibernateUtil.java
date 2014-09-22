package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Sunny on 4/4/14.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static{
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder SB = new StandardServiceRegistryBuilder();
            SB.applySettings(configuration.getProperties());
            StandardServiceRegistry serviceRegistry = SB.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
    }

    public static Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }

    public static void closeSession(Session session){
        if(session != null){
            session.close();
        }
    }


    public static void main(String[] args) {


    }
}
