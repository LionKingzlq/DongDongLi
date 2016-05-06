package com.ddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ddl.dao.InstructionAddressDao;
import com.ddl.model.InstructionAddress;
import com.ddl.service.IInstructionAddressService;

@Service(value="instructionAddressService")
@Repository
public class InstructionAddressService extends BaseService implements IInstructionAddressService {
    
    private InstructionAddressDao instructionAddressDao;

    public InstructionAddressDao getuserInfoDao() {
        return instructionAddressDao;
    }

    @Resource(name="instructionAddressDao")
    public void setuserInfoDao(InstructionAddressDao instructionAddressDao) {
        this.instructionAddressDao = instructionAddressDao;
    }

	@Override
	public Object get(Object object) {
		return instructionAddressDao.get((InstructionAddress)object);
	}

	@Override
	public List<?> getAll() {
		return instructionAddressDao.getAll();
	}

	@Override
	public int saveAll(String filePath) {
		return instructionAddressDao.saveAll(filePath);
	}
	
}