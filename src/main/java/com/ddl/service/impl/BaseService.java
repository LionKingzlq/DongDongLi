package com.ddl.service.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ddl.dao.BaseDao;
import com.ddl.service.IBaseService;

@Service(value = "baseService")
@Repository
public abstract class BaseService implements IBaseService {
	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	@Resource
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public boolean save(Object object) {
		try {
			Session session = baseDao.getSession();
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Object object) {
		try {
			Session session = baseDao.getSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Object object) {
		try {
			Session session = baseDao.getSession();
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}
}
