package entity;

import java.io.Serializable;
import java.util.Date;

public class Students implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sid;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String sex;
	private Date stime;
	private String address;

	public Students() {
	}

	public Students(String sid, String name, String sex, Date stime,
			String address) {
		// super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.stime = stime;
		this.address = address;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
