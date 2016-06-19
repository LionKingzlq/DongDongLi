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

import com.ddl.model.FAQ;
import com.ddl.model.InstructionAddress;
import com.ddl.model.Teacher;

@Repository
public class InstructionAddressDao extends BaseDao{

	public boolean delete(InstructionAddress address) {

		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery(
					"DELETE FROM InstructionAddress WHERE InstructionAddress.id=" + address.getId());
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
	
	public InstructionAddress get(InstructionAddress address){
		String sql = "SELECT * FROM InstructionAddress LEFT JOIN (SELECT id, name as adminName FROM Admin)AS A ON InstructionAddress.adminId = A.id WHERE InstructionAddress.id=" + address.getId();
		try {
			Session session = getSession();
			session.beginTransaction();
			InstructionAddress object = (InstructionAddress) session.createSQLQuery(sql).addEntity(InstructionAddress.class).list().get(0);
			session.getTransaction().commit();
			releaseSession(session);
			return object;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public boolean update(InstructionAddress address) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("UPDATE InstructionAddress SET name = ?, location=?, phone=?, adminId =? WHERE InstructionAddress.id=" + address.getId());
			
			sqlQuery.setString(0, address.getName());
			sqlQuery.setString(1, address.getLocation());
			sqlQuery.setString(2, address.getPhone());
			sqlQuery.setInteger(3, address.getAdminId());
			
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
	public List<?> getAll(){
		try {
			Session session = getSession();
			session.beginTransaction();
			List<?> list = session.createSQLQuery("SELECT * FROM InstructionAddress AS Address LEFT JOIN (SELECT id as adminId, name as adminName FROM Admin) AS A ON Address.adminId = A.adminId").addEntity(InstructionAddress.class).list();
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
					
					SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO InstructionAddress (name, location, phone, adminId) VALUES (?,?,?,?)");
					
					sqlQuery.setString(0, row.getCell(0).getStringCellValue());
					sqlQuery.setString(1, row.getCell(1).getStringCellValue());
					sqlQuery.setString(2, row.getCell(2).getStringCellValue());
					sqlQuery.setInteger(3, (int) row.getCell(3).getNumericCellValue());
					
					sqlQuery.addEntity(InstructionAddress.class);
					
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
