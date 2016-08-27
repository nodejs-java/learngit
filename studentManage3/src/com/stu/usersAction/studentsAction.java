package com.stu.usersAction;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.stu.studentInter.studentInter;
import com.stu.studentServiceImp.studentServiceImp;

import entity.Students;

public class studentsAction extends baseAction implements ModelDriven<Students> {
	
	private studentInter studentImp;
     
	public void setStudentImp(studentInter studentImp) {
		this.studentImp = studentImp;
	}

	public String query(){
		List<Students> list = studentImp.query();
		session.setAttribute("query_studentList",list);
		return "query_success";
	}
	
	public String delete(){
		String sid=request.getParameter("sid");
		studentImp.delete(sid);
		return "delete_success";
	}
	
	
	public String add(){
		stu.setSid((String)studentImp.increment());
		studentImp.insert(stu);
		return "add_success";
	}
	
	public String queryById(){
		String sid=request.getParameter("sid");
		Students stu1=studentImp.queryById(sid);
		session.setAttribute("update_student",stu1);
		return "queryById_success";
	}
	
	public String update(){
		studentImp.update(stu);
		return "update_success";
	}
	
	Students stu=new Students();

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.stu;
	}
	
	
}
