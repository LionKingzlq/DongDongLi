package com.ddl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.ddl.util.FormatUtil;

@Entity(name="Data")
public class Data {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="key")
	private String key;
	
	@Column(name="value")
	private String value;
	
	@Column(name="adminId")
	private int adminId;
	
	@Column(name="adminName")
	private String adminName;

	@Column(name="addTime")
	private Date addTime;
	
	/***
	 * 1、文字
	 * 2、图片资源
	 * 
	 */
	@Column(name="type")
	private int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAddTime() {
		return FormatUtil.Date2String(addTime);
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}
