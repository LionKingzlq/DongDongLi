package com.ddl.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ddl.dao.CourseDao;
import com.ddl.model.Course;
import com.ddl.service.ICourseService;

@Service(value="courseService")
@Repository(value="courseService")
public class CourseService extends BaseService implements ICourseService {

	private CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	@Resource
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	@Override
	public Object get(Object object) {
		return courseDao.get((Course)object);
	}
	@Override
	public List<Course> getAll() {
		return courseDao.getAllCourse();
	}
}
