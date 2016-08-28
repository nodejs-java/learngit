package com.stu.studentDaoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.stu.studentDaoInter.studentDaoInter;

import entity.Students;

public class StudentDaoImp extends JdbcDaoSupport implements studentDaoInter {

	public class StudentMapper implements RowMapper {
//		rowMapper = new RowMapper(){}
		@Override
		public Students mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			Students stu = new Students();
			stu.setSid(rs.getString("sid"));
			stu.setName(rs.getString("name"));
			stu.setSex(rs.getString("sex"));
			stu.setStime(rs.getDate("stime"));
		    stu.setAddress(rs.getString("address"));
			return stu;
		}

	}

	public class maxidMapper implements RowMapper {

		@Override
		public String mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			String ss=rs.getString("sid");
			return ss;
		}

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Students> query() {
		// TODO Auto-generated method stub
		String sql = "select sid,name,sex,stime,address from STUDENTS";
		return this.getJdbcTemplate().query(sql, new StudentMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Students queryById(String sid) {
		// TODO Auto-generated method stub
		String sql = "select sid,name,sex,stime,address from STUDENTS where sid=?";
		return this.getJdbcTemplate().queryForObject(sql,new Object[]{sid},new StudentMapper());
	}

	@Override
	public void update(Students stu) {
		// TODO Auto-generated method stub
       String sql="update STUDENTS set name=?,sex=?,stime=?,address=? where sid=?";
       this.getJdbcTemplate().update(sql,stu.getName(),stu.getSex(),stu.getStime(),stu.getAddress(),stu.getSid());
	}

	@Override
	public void delete(String sid) {
		// TODO Auto-generated method stub
        String sql="delete from STUDENTS where sid=?";
        this.getJdbcTemplate().update(sql,sid);
	}

	@Override
	public void insert(Students stu) {
		// TODO Auto-generated method stub
        String sql="insert into STUDENTS values(?,?,?,?,?)";
        this.getJdbcTemplate().update(sql,stu.getSid(),stu.getName(),stu.getSex(),stu.getStime(),stu.getAddress());
	}

	@SuppressWarnings("unchecked")
	@Override
	public String increment() {
		// TODO Auto-generated method stub
    	String sql="select max(sid) as sid from Students";
        String sid=this.getJdbcTemplate().queryForObject(sql,new maxidMapper());
        String sid1=sid.substring(1);
        int Isid=Integer.parseInt(sid1);
        Isid++;
        String sid2=String.valueOf(Isid);
        int len=sid2.length();
        for(int j=0;j<7-len;j++){
        	sid2='0'+sid2;
        }
        sid='s'+sid2;
		return sid;
	}

}
