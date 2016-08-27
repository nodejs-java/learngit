package Test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import entity.Students;

public class testSpring {
  
	@Test
	public void testspring(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-aware.xml");
		Session s=(Session) ((SessionFactory)ac.getBean("sessionFactory")).getCurrentSession();
		Transaction ts=s.beginTransaction();
		List<Students> list=s.createQuery("from Students").list();
		ts.commit();
		for(Students ss:list){
			System.out.println(ss.getName());
		}
	}
}
