package com.ddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ddl.dao.TeacherDao;
import com.ddl.model.Teacher;
import com.ddl.service.ITeachService;
import com.ddl.util.FileOperateUtil;


@Service(value="teacherService")
public class TeacherService extends BaseService implements ITeachService {

	@Resource
	private TeacherDao teacherDao;
	
	@Resource
	FileOperateUtil fileOperateUtil;
	
	@Override
	public Object get(Object object) {
		return teacherDao.get((Teacher)object);
	}

	@Override
	public boolean delete(Object object) {
		Teacher teacher = (Teacher)teacherDao.get((Teacher)object);
		return fileOperateUtil.deleteFile(teacher.getImgPath());
	}
	public List<?> getAll() {
		return teacherDao.getAll();
	}

}
