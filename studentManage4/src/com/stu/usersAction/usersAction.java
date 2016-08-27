package com.stu.usersAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.stu.userServiceInter.userServiceInter;
import com.stu.usersInter.usersDao;

import entity.Users;

@Controller
public class usersAction extends baseAction implements ModelDriven<Users> {
	
	@Resource
	private userServiceInter userServiceImp;

	Users user=new Users();
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
	
	public String Login(){	
	   
	   if(userServiceImp.usercheck(user)){
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
