package com.ddl.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.Course;

@Repository(value="courseDao")
public class CourseDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Course> getAllCourse() {
		try {
			Session session = getSession();
			session.beginTransaction();
			List<Course> list = session.createSQLQuery("select * from Course order by addressId").addEntity(Course.class).list();
			session.getTransaction().commit();
			System.out.println(list);
			return list;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public Course get(Course course) {
		try {
			Session session = getSession();
			session.beginTransaction();
			Course result = (Course)session.get(Course.class, course.getId());
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			System.err.println("checkCourse:"+e.getMessage());
			return null;
		}
	}
}
