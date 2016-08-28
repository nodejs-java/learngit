package com.stu.usersAction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stu.studentDaoImp.StudentDaoImp;
import com.stu.studentDaoInter.studentDaoInter;
import com.stu.studentServiceInter.studentServiceInter;

import entity.Students;

@Controller
@RequestMapping("/students")
public class studentsAction{
	
	@Resource
	private studentServiceInter studentServiceImp;

	
	@RequestMapping(value="/findAll")
	public String query(Model model){
		List<Students> list = studentServiceImp.query();
		model.addAttribute("list",list);
		return "students/Students_query_success";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String sid){
		studentServiceImp.delete(sid);
		return "redirect:findAll";
	}
	
	@RequestMapping(value="/add")
	public String add1(){
		return "students/Students_add";
	}
	
	@RequestMapping(value="/add_success",method=RequestMethod.POST)
	public String add(Students stu){
//		System.out.println(name);
//		System.out.println(stu.getName());
		stu.setSid((String)studentServiceImp.increment());
		studentServiceImp.insert(stu);
		return "students/Students_add_success";
	}
	
	@RequestMapping(value="/update")
	public String queryById(@RequestParam String sid,Model model){
		Students stu1=studentServiceImp.queryById(sid);
		model.addAttribute("update_student",stu1);
		return "students/Students_modify";
	}
	
	@RequestMapping(value="/update_success")
	public String update(Students stu){
//		System.out.println(stu.getName());
		studentServiceImp.update(stu);
		return "students/Students_modify_success";
	}
	
	@InitBinder

    public void InitBinder(ServletRequestDataBinder bin) {

              bin.registerCustomEditor(Date.class, new CustomDateEditor(

                                new SimpleDateFormat("yyyy-MM-dd"), true));

    }
	
}
