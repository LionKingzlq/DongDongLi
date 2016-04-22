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
	public void setUserDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public Object get(Object object) {
		return null;
	}
	@Override
	public List<?> getAll() {
		return adminDao.getAllAdmin();
	}

	@Override
	public boolean checkAdmin(Admin admin) {
		return adminDao.checkAdmin(admin);
	}
}
