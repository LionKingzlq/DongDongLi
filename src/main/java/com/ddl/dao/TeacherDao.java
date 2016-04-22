package com.ddl.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.Teacher;

@Repository
public class TeacherDao extends BaseDao{

	public Object get(Teacher teacher){
		try {
			Session session = getSession();
			session.beginTransaction();
			Object object = session.get(Teacher.class, (teacher).getId());
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
			List<?> list = session.createSQLQuery("SELECT * FROM Teacher").addEntity(Teacher.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
