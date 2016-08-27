package Test;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stu.usersAction.baseAction;
import com.stu.usersInter.usersDao;
import com.stu.userserviceImp.userserviceImp;

import entity.Users;

public class testLogin{

	@Test
	public void testLogin(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-aware.xml");
	    Users user=new Users(1,"zhangsan","123456");
	    usersDao userdao=(usersDao) ac.getBean("userimp");
		Assert.assertEquals(true, userdao.userLogin(user));
	}
}
