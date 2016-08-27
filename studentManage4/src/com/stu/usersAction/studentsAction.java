package com.stu.usersAction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.stu.studentDaoImp.StudentDaoImp;
import com.stu.studentDaoInter.studentDaoInter;
import com.stu.studentServiceInter.studentServiceInter;

import entity.Students;

@Controller
public class studentsAction extends baseAction implements ModelDriven<Students> {
	
	@Resource
	private studentServiceInter studentServiceImp;

	public String query(){
		List<Students> list = studentServiceImp.query();
		session.setAttribute("query_studentList",list);
		return "query_success";
	}
	
	public String delete(){
		String sid=request.getParameter("sid");
		studentServiceImp.delete(sid);
		return "delete_success";
	}
	
	
	public String add(){
		stu.setSid((String)studentServiceImp.increment());
		studentServiceImp.insert(stu);
		return "add_success";
	}
	
	public String queryById(){
		String sid=request.getParameter("sid");
		Students stu1=studentServiceImp.queryById(sid);
		session.setAttribute("update_student",stu1);
		return "queryById_success";
	}
	
	public String update(){
		studentServiceImp.update(stu);
		return "update_success";
	}
	
	Students stu=new Students();

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.stu;
	}
	
	
}
