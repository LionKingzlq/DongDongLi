package com.ddl.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.ddl.security.SpringSecurityUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ddl.model.Teacher;

@Repository
public class TeacherDao extends BaseDao {

	public boolean delete(Teacher teacher) {

		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery(
					"DELETE FROM Teacher WHERE Teacher.id=" + teacher.getId());
			int num = sqlQuery.executeUpdate();
			session.getTransaction().commit();
			releaseSession(session);
			if(num > 0){
				return true;
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return false;
	}
	
	public Teacher get(Teacher teacher) {

		try {
			Session session = getSession();
			session.beginTransaction();
			List<?> list = session.createSQLQuery(
					"SELECT * FROM Teacher LEFT JOIN (SELECT id as adminId, name as adminName FROM Admin) AS A ON Teacher.adminId = A.adminId WHERE Teacher.id="
							+ teacher.getId())
					.addEntity(Teacher.class).list();
			session.getTransaction().commit();
			releaseSession(session);
			if (list.size() > 0)
				return (Teacher) list.get(0);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return null;
	}
	
	public boolean save(Teacher teacher) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO Teacher (name, motto, position, honour, imgPath, content, adminId) VALUES (?,?,?,?,?,?,?)");
			
			sqlQuery.setString(0, teacher.getName());
			sqlQuery.setString(1, teacher.getMotto());
			sqlQuery.setString(2, teacher.getPosition());
			sqlQuery.setString(3, teacher.getHonour());
			sqlQuery.setString(4, teacher.getImgPath());
			sqlQuery.setString(5, teacher.getContent());
			sqlQuery.setInteger(6, teacher.getAdminId());
			
			sqlQuery.addEntity(Teacher.class);
			
			int num = sqlQuery.executeUpdate();
			session.getTransaction().commit();
			releaseSession(session);
			if(num != 0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	public boolean update(Teacher teacher) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("UPDATE Teacher SET name = ?, motto = ?, position = ?, honour = ?, imgPath = ?, content = ?, adminId =? WHERE Teacher.id="+teacher.getId());
			
			sqlQuery.setString(0, teacher.getName());
			sqlQuery.setString(1, teacher.getMotto());
			sqlQuery.setString(2, teacher.getPosition());
			sqlQuery.setString(3, teacher.getHonour());
			sqlQuery.setString(4, teacher.getImgPath());
			sqlQuery.setString(5, teacher.getContent());
			sqlQuery.setInteger(6, teacher.getAdminId());
			sqlQuery.addEntity(Teacher.class);
			
			int num = sqlQuery.executeUpdate();
			session.getTransaction().commit();
			releaseSession(session);
			if(num != 0){
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	
	public List<?> getAll() {
		try {
			Session session = getSession();
			session.beginTransaction();
			List<?> list = session
					.createSQLQuery(
							"SELECT * FROM Teacher LEFT JOIN (SELECT id as adminId, name as adminName FROM Admin) AS A ON Teacher.adminId = A.adminId")
					.addEntity(Teacher.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
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
					
					SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO Teacher (name, motto, position, honour, content, adminId) VALUES (?,?,?,?,?,?)");
					
					sqlQuery.setString(0, row.getCell(0).getStringCellValue());
					sqlQuery.setString(1, row.getCell(1).getStringCellValue());
					sqlQuery.setString(2, row.getCell(2).getStringCellValue());
					sqlQuery.setString(3, row.getCell(3).getStringCellValue());
					sqlQuery.setString(4, row.getCell(4).getStringCellValue());
					sqlQuery.setInteger(5, (int) row.getCell(5).getNumericCellValue());
//					sqlQuery.setInteger(5, SpringSecurityUtils.getCurrentId());

					sqlQuery.addEntity(Teacher.class);
					
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
	
}
