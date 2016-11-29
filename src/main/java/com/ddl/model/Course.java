package com.ddl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.ddl.util.FormatUtil;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity(name="Course")
public class Course {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="addressId")
	private int addressId;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="startTime")
	private String startTime;
	
	@Column(name="classDay")
	private String classDate;
	
	@Column(name="classTime")
	private String classTime;
	
	@Column(name="teacher")
	private String teacher;
	
	@Column(name="type")
	private String type;
	
	@Column(name="className")
	private String className;
	
	@Column(name="classRoom")
	private String classRoom;
	
	@Column(name="times")
	private int times;
	
	@Column(name="adminId")
	private int adminId;
	
	@Column(name="addTime")
	private Date addTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
