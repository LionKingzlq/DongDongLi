package com.ddl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.ddl.util.FormatUtil;


@Entity(name="BookRegistration")
public class BookRegistration {
	@Id
	@Column(name="id")
	private int id;

	@Column(name="campus")
	private String campus;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="course")
	private String course;
	
	@Column(name="teacherId")
	private int teacherId;
	
	@Column(name="addTime")
	private Date addTime;
	
	@Column(name="studentName")
	private String studentName;
	
	@Column(name="parentName")
	private String parentName;
	
	@Column(name="parentPhone")
	private String parentPhone;

	@Column(name="studentId")
	private String studentId;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getAddTime() {
		return FormatUtil.Date2String(addTime);
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
}
