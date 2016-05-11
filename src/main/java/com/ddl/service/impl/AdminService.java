package com.ddl.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ddl.dao.AdminDao;
import com.ddl.model.Admin;
import com.ddl.service.IAdminService;

@Service(value="adminService")
@Repository(value="adminService")
public class AdminService extends BaseService implements IAdminService {

	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	@Resource
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public Object get(Object object) {
		return adminDao.get((Admin)object);
	}
	@Override
	public List<Admin> getAll() {
		return adminDao.getAllAdmin();
	}

	@Override
	public int checkAdmin(Admin admin) {
		return adminDao.checkAdmin(admin);
	}
}
