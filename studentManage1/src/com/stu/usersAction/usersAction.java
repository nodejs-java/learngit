package com.stu.usersAction;

import com.opensymphony.xwork2.ModelDriven;
import com.stu.usersInter.usersDao;
import com.stu.userserviceImp.userserviceImp;

import entity.Users;

public class usersAction extends baseAction implements ModelDriven<Users> {
	

	Users user=new Users();
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
	public String Login(){	
	   usersDao userdao=new userserviceImp();
	   if(userdao.userLogin(user)){
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
