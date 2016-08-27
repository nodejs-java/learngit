package Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.stu.studentInter.studentInter;
import com.stu.studentServiceImp.studentServiceImp;

import entity.Students;
import myHibernateUtil.myHibernateUtil;

public class testStudentInsert {

	@Test
	public void saveStudent() {
		Session session = myHibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		Students stu1 = new Students("s0000001", "张三丰", "男",
				new java.util.Date(), "武当山");
		Students stu2 = new Students("s0000002", "郭靖", "男",
				new java.util.Date(), "洛阳");
		Students stu3 = new Students("s0000003", "黄蓉", "女",
				new java.util.Date(), "桃花岛");
		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		ts.commit();
	}

	@Test
	public void showStudent() {
		Session session = myHibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		String hql = "from Students";
		Query query = session.createQuery(hql);
		List<Students> list = query.list();
		ts.commit();
		for (Students stu : list) {
			System.out.println("姓名是:" + stu.getName());
		}
	}

	@Test
	public void increment() {
		studentServiceImp simp = new studentServiceImp();
		String sid = simp.increment();
		System.out.println(sid);
	}
	
	@Test
	public void queryById(){
		studentInter simp = new studentServiceImp();
		Students stu=simp.queryById("s0000002");
		System.out.print(stu.getName());
	}

}
