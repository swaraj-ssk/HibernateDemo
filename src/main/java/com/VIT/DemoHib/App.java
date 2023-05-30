package com.VIT.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
        Alien VIT = new Alien();
        VIT.setAid(103);
        VIT.setAname("Appi");
        VIT.setColor("White");
        
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
    
        session.save(VIT);
        
        tx.commit();
    }
}
