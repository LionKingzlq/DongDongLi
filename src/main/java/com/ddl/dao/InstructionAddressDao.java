package com.ddl.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.InstructionAddress;

@Repository
public class InstructionAddressDao extends BaseDao{

	public InstructionAddress get(InstructionAddress instructionAddress){
		try {
			Session session = getSession();
			session.beginTransaction();
			InstructionAddress object = (InstructionAddress) session.get(InstructionAddress.class, instructionAddress.getId());
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
			List<?> list = session.createSQLQuery("SELECT * FROM InstructionAddress").addEntity(InstructionAddress.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
