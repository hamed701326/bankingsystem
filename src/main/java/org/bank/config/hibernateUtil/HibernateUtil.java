package org.bank.config.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static SessionFactory sessionFactoryTwo;

    static{
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
