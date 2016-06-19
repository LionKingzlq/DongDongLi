package com.ddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ddl.dao.DataDao;
import com.ddl.model.Data;
import com.ddl.service.IDataService;

@Service(value="dataService")
@Repository(value="dataService")
public class DataService extends BaseService implements IDataService{

	@Resource
	private DataDao dataDao;
	
	@Override
	public Object get(Object object) {
		return dataDao.get((Data)object);
	}

	@Override
	public List<?> getAll() {
		return dataDao.getAll();
	}

	@Override
	public int saveAll(String filePath, int adminId) {
		return dataDao.saveAll(filePath, adminId);
	}
	@Override
	public boolean update(Object object) {
		return dataDao.update((Data)object);
	}
	@Override
	public boolean delete(Object object) {
		return dataDao.delete((Data)object);
	}

}
