package com.stu.usersAction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class baseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware,ApplicationContextAware {
   
	protected ServletContext application;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected HttpSession session;
	protected ApplicationContext ac;
	@Override
	public void setServletContext(ServletContext application) {
		// TODO Auto-generated method stub
		this.application=application;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
		this.session=request.getSession();
	}

	@Override
	public void setApplicationContext(ApplicationContext ac)
			throws BeansException {
		
		this.ac=ac;
	}

}
