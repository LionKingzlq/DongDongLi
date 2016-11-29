package com.ddl.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
			releaseSession(session);
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
					+ "' and passWord = '" + admin.getPassWord() + "'");
			session.getTransaction().commit();
			
			Object result = query.uniqueResult();
			if(result != null){
				int id = Integer.valueOf(result.toString());
				return id;
			}
			releaseSession(session);
			return 0;
		} catch (Exception e) {
			logger.error("checkAdmin:"+e.getMessage());
			return 0;
		}
	}
	
	public Admin get(Admin admin) {
		try {
			Session session = getSession();
			session.beginTransaction();
			Admin result = (Admin)session.get(Admin.class, admin.getId());
			session.getTransaction().commit();
			releaseSession(session);
			return result;
		} catch (Exception e) {
			logger.error("checkAdmin:"+e.getMessage());
			return null;
		}
	}

	public List<Admin> getAuthorityName(String username){
		try {
			Session session = getSession();
			SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM  ADMIN WHERE ADMIN.NAME = :name");
			sqlQuery.setString("name", username);
			List<Admin> list = sqlQuery.addEntity(Admin.class).list();
			releaseSession(session);
			return list;
		} catch (Exception e) {
			logger.error("checkAdmin:"+e.getMessage());
			return null;
		}
	}
}
