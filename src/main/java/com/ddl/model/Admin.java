package com.ddl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.ddl.util.FormatUtil;


@Entity(name="Admin")
public class Admin {
	@Id
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="passWord")
	private String passWord;

	@Column(name="role")
	private String role;

	@Column(name="adminId")
	private int adminId;
	
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Column(name="addTime")
	private Date addTime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddTime() {
		return FormatUtil.Date2String(addTime);
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
