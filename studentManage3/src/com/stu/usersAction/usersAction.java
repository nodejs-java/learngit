package com.stu.usersAction;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.stu.usersInter.usersDao;

import entity.Users;

public class usersAction extends baseAction implements ModelDriven<Users> {
	
    private usersDao userImp;
	
	public void setUserImp(usersDao userImp) {
		this.userImp = userImp;
	}

	Users user=new Users();
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
	
	public String Login(){	
	   
	   if(userImp.userLogin(user)){
//		if(true){
		  session.setAttribute("login_name",user.getUsername());
		  System.out.print("yong"+user.getUsername());
	      return "login_success";
	   }else{
		   return "login_fail";
	   }
	}
	
	public String logout(){
		if(session.getAttribute("login_name")!=null){
			session.removeAttribute("login_name");
		}
		return "logout_success";
	}

}
