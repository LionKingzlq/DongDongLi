package com.ddl.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.BookRegistration;

@Repository
public class BookRegistrationDao extends BaseDao{

	public Object get(BookRegistration bookRegistration){
		try {
			Session session = getSession();
			session.beginTransaction();
			Object object = session.get(BookRegistration.class, (bookRegistration).getId());
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
			List<?> list = session.createSQLQuery("SELECT * FROM BookRegistration").addEntity(BookRegistration.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
