package com.pw.bills.utils;
import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private String address;
	private Integer sex;
	private Date birthday;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSex() {
		return sex;
	}
	public void setGender(Integer gender) {
		this.sex = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User(Integer id, String name, String address, Integer gender, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.sex = gender;
		this.birthday = birthday;
	}
	public User() {
		super();
	}
	
}
