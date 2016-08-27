package com.stu.userServiceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stu.userServiceInter.userServiceInter;
import com.stu.usersInter.usersDao;

import entity.Users;

@Service
public class UserServiceImp implements userServiceInter {

	@Resource
    private usersDao usersDaoImp;
	
	@Override
	public boolean usercheck(Users user) {
		// TODO Auto-generated method stub
		if(usersDaoImp.userLogin(user)!=null){
			return true;
		}else{
			return false;
		}	
	}

}
