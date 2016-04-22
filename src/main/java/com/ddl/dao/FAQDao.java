package com.ddl.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.FAQ;

@Repository
public class FAQDao extends BaseDao{

	public Object get(FAQ faq){
		try {
			Session session = getSession();
			session.beginTransaction();
			Object object = session.get(FAQ.class, (faq).getId());
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
			List<?> list = session.createSQLQuery("SELECT * FROM FAQ").addEntity(FAQ.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
