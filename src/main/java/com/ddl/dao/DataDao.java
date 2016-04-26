package com.ddl.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.Data;

@Repository
public class DataDao extends BaseDao{

	public Data get(Data data){
		try {
			Session session = getSession();
			session.beginTransaction();
			Data object = (Data) session.get(Data.class, (data).getId());
			session.getTransaction().commit();
			return object;	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Data> getAll(){
		try {
			Session session = getSession();
			session.beginTransaction();
			List<Data> list = session.createSQLQuery("SELECT * FROM Data").addEntity(Data.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
