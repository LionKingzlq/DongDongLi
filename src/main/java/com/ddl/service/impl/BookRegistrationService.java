package com.ddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ddl.dao.BookRegistrationDao;
import com.ddl.service.IBookRegistrationService;

@Service(value="bookRegistrationService")
public class BookRegistrationService extends BaseService implements IBookRegistrationService{

	@Resource
	private BookRegistrationDao bookRegistrationDao;
	
	@Override
	public Object get(Object object) {
		
		return null;
	}

	@Override
	public List<?> getAll() {
		System.out.println("adll");
		return null;
	}

	
}
