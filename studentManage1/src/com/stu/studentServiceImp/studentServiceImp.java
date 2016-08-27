package com.stu.studentServiceImp;

import java.util.List;

import myHibernateUtil.myHibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stu.studentInter.studentInter;

import entity.Students;

public class studentServiceImp implements studentInter {

	@Override
	public List<Students> query() {
		// TODO Auto-generated method stub
		Transaction ts=null;
		List<Students> list=null;
		Session session=null;
		String hql="from Students";
		try{
			session = myHibernateUtil.getSessionFactory().getCurrentSession();
			ts=session.beginTransaction();
			Query query1=session.createQuery(hql);
			list=query1.list();
			ts.commit();
		    return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
		finally{
			if(ts!=null){
				ts=null;
			}
		}
	}

	@Override
	public Students queryById(String sid) {
		// TODO Auto-generated method stub
		Transaction ts=null;
		Students stu=null;
		Session session=null;
		String hql="from Students where sid=?";
		try{
			session = myHibernateUtil.getSessionFactory().getCurrentSession();
			ts=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter(0,sid);
			stu=(Students) query.uniqueResult();
			ts.commit();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			ts.commit();
		}
		finally{
			if(ts!=null){
				ts=null;
			}
		}
		return stu;
	}

	@Override
	public void update(Students stu) {
		// TODO Auto-generated method stub
		Transaction ts=null;
		Session session=null;
		try{
			session = myHibernateUtil.getSessionFactory().getCurrentSession();
			ts=session.beginTransaction();
			session.update(stu);
			ts.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
			ts.commit();
		}
		finally{
			if(ts!=null){
				ts=null;
			}
		}
	}

	@Override
	public void delete(String sid) {
		// TODO Auto-generated method stub
		Transaction ts=null;
		Session session=null;
		
		try{
			session = myHibernateUtil.getSessionFactory().getCurrentSession();
		    ts=session.beginTransaction();
		    Students stu = (Students) session.get(Students.class, sid);
		    session.delete(stu);
		    ts.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
			ts.commit();
		}
		finally{
			if(ts!=null){
				ts=null;
			}
		}
	}

	@Override
	public void insert(Students stu) {
		// TODO Auto-generated method stub
		Transaction ts=null;
		Session session=null;
		try{
			session=myHibernateUtil.getSessionFactory().getCurrentSession();
			ts=session.beginTransaction();
			session.save(stu);
			ts.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
			ts.commit();
		}
		finally{
			if(ts!=null){
				ts=null;
			}
		}
	}
	
    public String increment(){
    	Transaction ts=null;
		Session session=null;
		String sid=null;
	    try{
	    	session = myHibernateUtil.getSessionFactory().getCurrentSession();
	    	ts=session.beginTransaction();
	    	Query query=session.createQuery("select max(sid) from Students");
	        sid=(String) query.uniqueResult();
	        ts.commit();
	        String sid1=sid.substring(1);
	        int Isid=Integer.parseInt(sid1);
	        Isid++;
	        String sid2=String.valueOf(Isid);
	        int len=sid2.length();
	        for(int j=0;j<7-len;j++){
	        	sid2='0'+sid2;
	        }
	        
	        sid='s'+sid2;
	       
	    }
	    catch(Exception ex){
	    	ex.printStackTrace();
	    	ts.commit();
	    }
	    finally{
	    	if(ts!=null){
	    		ts=null;
	    	}
	    }
		return sid;
		
	}

}
