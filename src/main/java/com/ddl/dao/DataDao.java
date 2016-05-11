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

@Repository
public class DataDao extends BaseDao{

	public Data get(Data data){
		String sql = "SELECT * FROM Data LEFT JOIN (SELECT id, name as adminName FROM Admin)AS A ON Data.adminId = A.id WHERE Data.id=" + data.getId();
		try {
			Session session = getSession();
			session.beginTransaction();
			Data object = (Data) session.createSQLQuery(sql).addEntity(Data.class).list().get(0);
			session.getTransaction().commit();
			releaseSession(session);
			return object;	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Data> getAll(){
		String sql = "SELECT * FROM Data LEFT JOIN (SELECT id as adminId, name as adminName FROM Admin) AS A ON Data.adminId = A.adminId";
		try {
			Session session = getSession();
			session.beginTransaction();
			List<Data> list = session.createSQLQuery(sql).addEntity(Data.class).list();
			session.getTransaction().commit();
			releaseSession(session);
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean delete(Data data) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM Data WHERE Data.id=" + data.getId());
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
					
					SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO Data (key, value, type, adminId) VALUES (?,?,?,?)");
					
					sqlQuery.setString(0, row.getCell(0).getStringCellValue());
					sqlQuery.setString(1, row.getCell(1).getStringCellValue());
					sqlQuery.setInteger(2, (int) row.getCell(2).getNumericCellValue());
					sqlQuery.setInteger(3, (int) row.getCell(3).getNumericCellValue());
					
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
}
