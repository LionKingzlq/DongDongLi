package com.ddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ddl.dao.TeacherDao;
import com.ddl.model.Teacher;
import com.ddl.service.ITeacherService;
import com.ddl.util.FileOperateUtil;


@Service(value="teacherService")
public class TeacherService extends BaseService implements ITeacherService {

	@Resource
	private TeacherDao teacherDao;
	
	@Resource
	FileOperateUtil fileOperateUtil;
	
	@Override
	public Object get(Object object) {
		return teacherDao.get((Teacher)object);
	}
	
	public List<?> getAll() {
		return teacherDao.getAll();
	}
	
	@Override
	public int saveAll(String filePath) {
		return teacherDao.saveAll(filePath);
	}
	
	@Override
	public boolean update(Object object) {
		return teacherDao.update((Teacher)object);
	}
	@Override
	public boolean delete(Object object) {
		return teacherDao.delete((Teacher)object);
	}
}
