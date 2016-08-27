package com.stu.usersAction;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.stu.studentInter.studentInter;
import com.stu.studentServiceImp.studentServiceImp;

import entity.Students;

public class studentsAction extends baseAction implements ModelDriven<Students> {
     
	public String query(){
		studentInter stuinter=new studentServiceImp();
		List<Students> list = stuinter.query();
		session.setAttribute("query_studentList",list);
		return "query_success";
	}
	
	public String delete(){
		studentInter stuinter=new studentServiceImp();
		String sid=request.getParameter("sid");
		stuinter.delete(sid);
		return "delete_success";
	}
	
	
	public String add(){
		studentInter stuinter=new studentServiceImp();
		studentServiceImp simp=new studentServiceImp();
		stu.setSid((String)simp.increment());
		stuinter.insert(stu);
		return "add_success";
	}
	
	public String queryById(){
		studentInter stuinter=new studentServiceImp();
		String sid=request.getParameter("sid");
		Students stu1=stuinter.queryById(sid);
		session.setAttribute("update_student",stu1);
		return "queryById_success";
	}
	
	public String update(){
		studentInter stuinter=new studentServiceImp();
		stuinter.update(stu);
		return "update_success";
	}
	
	Students stu=new Students();

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.stu;
	}
	
	
}
