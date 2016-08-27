package com.stu.test;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testMain{
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext application=new ClassPathXmlApplicationContext("classpath:spring-aware.xml");
		testStudent ts=(testStudent) application.getBean("testStudent");
		ts.test();
		
	}

	
}
