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

import com.ddl.model.Data;
import com.ddl.model.FAQ;
import com.ddl.model.InstructionAddress;

@Repository
public class FAQDao extends BaseDao{
	
	public FAQ get(FAQ faq){
		String sql = "SELECT * FROM FAQ LEFT JOIN (SELECT id, name as adminName FROM Admin)AS A ON FAQ.adminId = A.id WHERE FAQ.id=" + faq.getId();
		try {
			Session session = getSession();
			session.beginTransaction();
			FAQ object = (FAQ) session.createSQLQuery(sql).addEntity(FAQ.class).list().get(0);
			session.getTransaction().commit();
			releaseSession(session);
			return object;	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<FAQ> getAll(){
		try {
			Session session = getSession();
			session.beginTransaction();
			List<FAQ> list = session.createSQLQuery("SELECT * FROM FAQ LEFT JOIN (SELECT id as adminId, name as adminName from Admin) AS a ON FAQ.adminId = a.adminId").addEntity(FAQ.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public boolean delete(FAQ faq) {

		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM FAQ WHERE FAQ.id=" + faq.getId());
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
					
					SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO FAQ (question, answer, adminId) VALUES (?,?,?)");
					
					sqlQuery.setString(0, row.getCell(0).getStringCellValue());
					sqlQuery.setString(1, row.getCell(1).getStringCellValue());
					sqlQuery.setInteger(2, (int) row.getCell(2).getNumericCellValue());
					
					sqlQuery.addEntity(FAQ.class);
					
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
	
	public boolean update(FAQ faq) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("UPDATE FAQ SET question = ?, answer=?, adminId =? WHERE FAQ.id=" + faq.getId());
			
			sqlQuery.setString(0, faq.getQuestion());
			sqlQuery.setString(1, faq.getAnswer());
			sqlQuery.setInteger(2, faq.getAdminId());
			
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
	
}
