package com.ddl.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.Admin;

@Repository(value="adminDao")
public class AdminDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmin() {
		try {
			Session session = getSession();
			session.beginTransaction();
			List<Admin> list = session.createSQLQuery("select * from Admin").addEntity(Admin.class).list();
			session.getTransaction().commit();
			System.out.println(list);
			return list;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	public int checkAdmin(Admin admin) {
		try {
			Session session = getSession();
			session.beginTransaction();

			Query query = session.createSQLQuery("SELECT id FROM Admin where name = '" + admin.getName()
					+ "' and password = '" + admin.getPassWord() + "'");
			session.getTransaction().commit();
			
			Object result = query.uniqueResult();
			if(result != null){
				// BigInteger
				int id = Integer.valueOf(result.toString());
				return id;
			}
			return 0;
		} catch (Exception e) {
			System.err.println("checkAdmin:"+e.getMessage());
			return 0;
		}
	}
	
	public Admin get(Admin admin) {
		try {
			Session session = getSession();
			session.beginTransaction();
			Admin result = (Admin)session.get(Admin.class, admin.getId());
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			System.err.println("checkAdmin:"+e.getMessage());
			return null;
		}
	}
}
