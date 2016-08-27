package com.stu.studentDaoInter;

import java.util.List;

import entity.Students;

public interface studentDaoInter {
	
	public List<Students> query();
	
	public Students queryById(String sid);
	
	public void update(Students stu);
	
	public void delete(String sid);
	
	public void insert(Students stu);
	
	public String increment();

}
