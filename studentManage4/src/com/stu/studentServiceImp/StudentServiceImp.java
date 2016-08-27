package com.stu.studentServiceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.stu.studentDaoInter.studentDaoInter;
import com.stu.studentServiceInter.studentServiceInter;

import entity.Students;

@Service
public class StudentServiceImp implements studentServiceInter {

	@Resource
	private studentDaoInter studentDaoImp;
	
	@Override
	public List<Students> query() {
		// TODO Auto-generated method stub	
		return studentDaoImp.query();
	}

	@Override
	public Students queryById(String sid) {
		// TODO Auto-generated method stub
		return studentDaoImp.queryById(sid);
	}

	@Override
	public void update(Students stu) {
		// TODO Auto-generated method stub
		studentDaoImp.update(stu);
	}

	@Override
	public void delete(String sid) {
		// TODO Auto-generated method stub
		studentDaoImp.delete(sid);
	}

	@Override
	public void insert(Students stu) {
		// TODO Auto-generated method stub
		studentDaoImp.insert(stu);
	}

	@Override
	public String increment() {
		// TODO Auto-generated method stub	
		return studentDaoImp.increment();
	}

}
