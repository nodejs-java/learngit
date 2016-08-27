package test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class testMain implements ApplicationContextAware{
	
	protected static ApplicationContext application;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testStudent ts=(testStudent) application.getBean("testStudent");
		ts.test();
		
	}

	@Override
	public void setApplicationContext(ApplicationContext application)
			throws BeansException {
		// TODO Auto-generated method stub
		this.application=application;
	}

}
