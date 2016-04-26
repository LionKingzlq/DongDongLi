package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ddl.model.InstructionAddress;
import com.ddl.service.IInstructionAddressService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/address")
public class InstructionAddressController {

	@Resource
	private IInstructionAddressService instructionAddressService;
	
	@RequestMapping(value="")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="index")
	public String Index(){
		return "admin/index";
	}
	
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
}
