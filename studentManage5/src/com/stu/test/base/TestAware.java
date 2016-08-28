package com.stu.test.base;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.stu.studentDaoImp.StudentDaoImp;
import com.stu.studentDaoInter.studentDaoInter;
import com.stu.studentServiceImp.StudentServiceImp;
import com.stu.studentServiceInter.studentServiceInter;
import com.stu.userServiceInter.userServiceInter;
import com.stu.usersInter.usersDao;

import entity.Students;
import entity.Users;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAware extends UnitTestBase {
	
	public TestAware() {
		super("classpath:spring-aware.xml");
	}
	/*
	@Test
	public void testCheck() {
		userServiceInter ud=super.getBean("userServiceImp");
		Users u=new Users(1,"zhangsan","123456");
//		Users user=ud.userLogin(u);
//		System.out.println("user的名字是:"+user.getUsername());
		Assert.assertEquals(true,ud.usercheck(u));
	}
	*/
	
	@Test
	public void testStudent(){
		studentDaoInter sdi=super.getBean("studentDaoImp");
//		System.out.println(sdi.increment());
		List<Students> list=sdi.query();
		for(Students stu:list){
			System.out.println("名字:"+stu.getName());
		}
	}
	
	@Test 
	public void testStudentService(){
		studentServiceInter s=new StudentServiceImp();
		List<Students> list=s.query();
		for(Students stu:list){
			System.out.println("名字:"+stu.getName());
		}
	}
}
