package Test;

import junit.framework.Assert;
import myHibernateUtil.myHibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.stu.usersInter.usersDao;
import com.stu.userserviceImp.userserviceImp;

import entity.Users;


public class testHibernate {
    @Test
	public void testcreatetable(){
    	Configuration config=new Configuration().configure();
//    	ServiceRegistry st=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
//    	SessionFactory sessionfactory=config.buildSessionFactory(st);
    	SchemaExport export=new SchemaExport(config);
    	export.create(true,true);
    }
    
    @Test
    public void testsaveUser(){
//    	Configuration config=new Configuration().configure();
//    	ServiceRegistry st=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
//    	SessionFactory sessionfactory=config.buildSessionFactory(st);
    	Session session=myHibernateUtil.getSessionFactory().getCurrentSession();
    	
    	Transaction ts=session.beginTransaction();
    	Users u=new Users();
    	u.setUsername("zhangsan");
    	u.setPassword("123456");
    	session.save(u);
    	ts.commit();
    }
    
   
	@SuppressWarnings("deprecation")
	@Test 
    public void testuserimp(){
    	Users u=new Users(1,"zhangsan","123");
    	usersDao ud=new userserviceImp();
    	Assert.assertEquals(true, ud.userLogin(u)); 
    }
   
}
