package com.stu.usersAction;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.stu.userServiceInter.userServiceInter;
import com.stu.usersInter.usersDao;

import entity.Users;

@Controller
@RequestMapping("users")
public class usersAction {

	private userServiceInter userServiceImp;
	@Autowired
	public void setUserServiceImp(userServiceInter userServiceImp) {
		this.userServiceImp = userServiceImp;
	}
    @RequestMapping(value="/login",method=RequestMethod.POST)
	public String Login(@ModelAttribute Users user,HttpSession session){	 
	   if(userServiceImp.usercheck(user)){
		  session.setAttribute("login_name",user.getUsername());
	      return "users/Users_login_success";
	   }else{
		   return "users/Users_login";
	   }
	}
	
    @RequestMapping(value="/logout")
	public String logout(HttpSession session){
		if(session.getAttribute("login_name")!=null){
			session.removeAttribute("login_name");
		}
		return "users/Users_login";
	}

}
