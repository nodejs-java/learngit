package com.stu.usersDaoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.stu.usersInter.usersDao;

import entity.Users;


public class UsersDaoImp extends JdbcDaoSupport implements usersDao {

    public class UserMapper implements RowMapper{

		@Override
		public Users mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			Users user=new Users();
			user.setUid(rs.getInt("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
    	
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public Users userLogin(Users u) {
		// TODO Auto-generated method stub
		String sql="select * from USERS where username=? and password = ?";    
	    return this.getJdbcTemplate().queryForObject(sql,new Object[]{u.getUsername(),u.getPassword()}, new UserMapper());
	}
}
