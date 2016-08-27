package com.stu.userserviceImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.stu.usersInter.usersDao;

import entity.Users;


public class userserviceImp implements usersDao {

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean userLogin(Users u) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		String hql="";
		Session session=null;
		try{
			session=sessionFactory.getCurrentSession();
			tx=session.beginTransaction();
			hql="from Users where username=? and password=?";
		    System.out.print("password:"+u.getPassword());
			Query query=session.createQuery(hql);
			query.setParameter(0,u.getUsername());
			query.setParameter(1,u.getPassword());
			Users user=(Users) query.uniqueResult();
			tx.commit();
			if(user!=null){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
		
	}

}
