package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddl.model.InstructionAddress;
import com.ddl.model.InstructionAddress;
import com.ddl.service.IInstructionAddressService;
import com.ddl.util.FileOperateUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/address")
public class InstructionAddressController {
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	@Resource
	private IInstructionAddressService instructionAddressService;
	
	@Resource(name="fileOperateUtil")
	private FileOperateUtil fileOperateUtil;
	
	@ResponseBody
	@RequestMapping(value="add",method= RequestMethod.POST)
	public JSONObject add(InstructionAddress address){
		JSONObject result = new JSONObject();
		boolean flag = instructionAddressService.save(address);
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method= RequestMethod.POST)
	public JSONObject delete(InstructionAddress address){
		JSONObject result = new JSONObject();
		boolean flag = instructionAddressService.delete(address);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method= RequestMethod.GET)
	public JSONObject get(InstructionAddress address){
		JSONObject result = new JSONObject();
		InstructionAddress address2 = (InstructionAddress)instructionAddressService.get(address);
		result.put("address", address2);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method= RequestMethod.POST)
	public JSONObject update(InstructionAddress address){
		JSONObject result = new JSONObject();
		boolean flag = instructionAddressService.update(address);
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/addressInPage",method = RequestMethod.GET)
	public JSONObject getAll(int pageNum){
		
		JSONObject result = new JSONObject();
		List<InstructionAddress> addresses = (List<InstructionAddress>) instructionAddressService.getAll();
		result.put("array", addresses);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "addressAddList", method = RequestMethod.POST)
	public JSONObject memberAddList(HttpServletRequest request) {
		JSONObject result = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			String filePath = fileOperateUtil.upLoadFile(request);
			int num = instructionAddressService.saveAll(filePath);
			result.put("code", "200");
			result.put("num", num);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			result.put("code", "400");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteMore",method = RequestMethod.POST)
	public void deleteMore(int[] ids){
		for (int id:ids) {
			InstructionAddress address = new InstructionAddress();
			address.setId(id);
			instructionAddressService.delete(address);
		}
	}
}
