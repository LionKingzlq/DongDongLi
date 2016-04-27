package com.ddl.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.Teacher;

@Repository
public class TeacherDao extends BaseDao{

	public Teacher get(Teacher teacher){
		try {
			Session session = getSession();
			session.beginTransaction();
			Teacher object = (Teacher)session.get(Teacher.class, (teacher).getId());
			session.getTransaction().commit();
			return object;	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<?> getAll(){
		try {
			Session session = getSession();
			session.beginTransaction();
			List<?> list = session.createSQLQuery("SELECT * FROM Teacher LEFT JOIN (SELECT id as adminId, name as adminName FROM Admin) AS A ON Teacher.adminId = A.adminId").addEntity(Teacher.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
