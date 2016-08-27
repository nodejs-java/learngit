package com.stu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;



@RunWith(BlockJUnit4ClassRunner.class)
public class TestAware extends UnitTestBase {
	
	public TestAware() {
		super("classpath:application.xml");
	}
	
//	@Test
//	public void testMoocApplicationContext() {
//		System.out.println("testMoocApplicationContext : " + super.getBean("moocApplicationContext").hashCode());
//	}
	
	@Test
	public void textMoocBeanName() {
		testStudent ts=super.getBean("testStudent");
		ts.test();
	}
	
}
