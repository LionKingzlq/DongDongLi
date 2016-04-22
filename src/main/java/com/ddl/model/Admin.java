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

	@Column(name="admin")
	private String admin;
	
	@Column(name="passWord")
	private String passWord;
	
	@Column(name="addTime")
	private Date addTime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAddTime() {
		return FormatUtil.Date2String(addTime);
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
