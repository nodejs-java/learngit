package myHibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entity.Users;


public class myHibernateUtil {
     private static SessionFactory sessionFactory;
     
     private myHibernateUtil(){}

     static{
    	 Configuration config=new Configuration().configure();
    	 ServiceRegistry st=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	 sessionFactory=config.buildSessionFactory(st);
     }
     
     public static SessionFactory getSessionFactory(){
    	 return sessionFactory;
     } 
     
     public static Session getSession(){
    	 return sessionFactory.getCurrentSession();
     }
     
}
