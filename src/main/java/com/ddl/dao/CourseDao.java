package com.ddl.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.Course;

@Repository(value="courseDao")
public class CourseDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Course> getAllCourse() {
		String sql = "select * from Course LEFT JOIN (SELECT id AS adminId, name as adminName FROM Admin) AS A ON Course.adminId=A.adminId order by id";
		try {
			Session session = getSession();
			session.beginTransaction();
			List<Course> list = session.createSQLQuery(sql).addEntity(Course.class).list();
			session.getTransaction().commit();
			releaseSession(session);
			return list;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public Course get(Course course) {
		String sql = "select * from Course LEFT JOIN (SELECT id AS adminId, name as adminName FROM Admin) AS A ON Course.adminId=A.adminId WHERE id = " + course.getId();
		try {
			Session session = getSession();
			session.beginTransaction();
			Course result = (Course)session.createSQLQuery(sql).addEntity(Course.class).list().get(0);
			session.getTransaction().commit();
			releaseSession(session);
			return result;
		} catch (Exception e) {
			System.err.println("checkCourse:"+e.getMessage());
			return null;
		}
	}
	
	public boolean delete(Course course) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM Course WHERE Course.id=" + course.getId());
			int num = sqlQuery.executeUpdate();
			session.getTransaction().commit();
			releaseSession(session);
			if(num > 0){
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	
	public int saveAll(String filePath) {
		int result = 0;
		if (!filePath.endsWith(".xlsx") && !filePath.endsWith(".xls")) {
			return result;
		}
		try {
			Session session = getSession();
			session.beginTransaction();
			
			Workbook workbook = WorkbookFactory.create(new File(filePath));
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
					Row row = sheet.getRow(j);
					
					SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO Course (addressId, grade, startTime, classDay, classTime, teacher, type, className, classRoom, times, adminId) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
					
					sqlQuery.setInteger(0, (int) row.getCell(0).getNumericCellValue());
					sqlQuery.setString(1, row.getCell(1).getStringCellValue());
					sqlQuery.setString(2, row.getCell(2).getStringCellValue());
					sqlQuery.setString(3, row.getCell(3).getStringCellValue());
					sqlQuery.setString(4, row.getCell(4).getStringCellValue());
					sqlQuery.setString(5, row.getCell(5).getStringCellValue());
					sqlQuery.setString(6, row.getCell(6).getStringCellValue());
					sqlQuery.setString(7, row.getCell(7).getStringCellValue());
					sqlQuery.setString(8, row.getCell(8).getStringCellValue());
					sqlQuery.setInteger(9, (int) row.getCell(9).getNumericCellValue());
					sqlQuery.setInteger(10, (int) row.getCell(10).getNumericCellValue());
					
					sqlQuery.addEntity(Course.class);
					result += sqlQuery.executeUpdate();
				}
			}
			session.getTransaction().commit();
			releaseSession(session);
			
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Boolean update(Course course) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("UPDATE Course SET addressId=?, grade=?, startTime=?, classDay=?, classTime=?, teacher=?, type=?, className=?, classRoom=?, adminId=?  WHERE Course.id=" + course.getId());
			
			sqlQuery.setInteger(0, course.getAddressId());
			sqlQuery.setString(1, course.getGrade());
			sqlQuery.setString(2, course.getStartTime());
			sqlQuery.setString(3, course.getClassDay());
			sqlQuery.setString(4, course.getClassTime());
			sqlQuery.setString(5, course.getTeacher());
			sqlQuery.setString(6, course.getType());
			sqlQuery.setString(7, course.getClassName());
			sqlQuery.setString(8, course.getClassRoom());
			sqlQuery.setInteger(9, course.getAdminId());
			
			int num = sqlQuery.executeUpdate();
			session.getTransaction().commit();
			releaseSession(session);
			if(num > 0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
}
