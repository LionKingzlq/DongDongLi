package com.ddl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.ddl.model.Teacher;

@Repository(value="baseDao")
public class BaseDao extends DaoSupport {

	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = createHibernateTemplate(sessionFactory);
	}

	public Session getSession() {
		if (this.sessionFactory == null) {
			throw new HibernateException("Session Create Fail,SessionFactory is null!");
		}
		return this.sessionFactory.openSession();
	}

	protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	@Override
	protected void checkDaoConfig() throws IllegalArgumentException {
		if (this.hibernateTemplate == null) {
			throw new IllegalArgumentException("'sessionFactory' or 'hibernateTemplate' is required");
		}
	}

	protected final Session getSession(boolean allowCreate)
			throws DataAccessResourceFailureException, IllegalStateException {
		return (!allowCreate ? SessionFactoryUtils.getSession(getSessionFactory(), false)
				: SessionFactoryUtils.getSession(getSessionFactory(),
						this.hibernateTemplate.getEntityInterceptor(),
						this.hibernateTemplate.getJdbcExceptionTranslator()));
	}

	protected final DataAccessException convertHibernateAccessException(HibernateException ex) {
		return this.hibernateTemplate.convertHibernateAccessException(ex);
	}

	protected final void releaseSession(Session session) {
		SessionFactoryUtils.releaseSession(session, getSessionFactory());
		if (null != session)
			session = null;
	}

	public final void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public final HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}
	
	public Boolean save(Object object) {
		try {
			
			Session session = getSession();
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Boolean update(Object object) {
		try {
			
			Session session = getSession();
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public Boolean delete(Object object) {
		try {
			Session session = getSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
