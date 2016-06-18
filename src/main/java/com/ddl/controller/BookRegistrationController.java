package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ddl.model.Admin;
import com.ddl.model.BookRegistration;
import com.ddl.service.IBookRegistrationService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/book")
public class BookRegistrationController {

	@Resource
	private IBookRegistrationService bookRegistrationService;
	
	@ResponseBody
	@RequestMapping(value="add",method= RequestMethod.POST)
	public JSONObject add(Admin admin){
		JSONObject result = new JSONObject();
		boolean flag = bookRegistrationService.save(admin);
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method= RequestMethod.POST)
	public JSONObject delete(Admin admin){
		JSONObject result = new JSONObject();
		boolean flag = bookRegistrationService.delete(admin);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method= RequestMethod.GET)
	public JSONObject get(Admin admin){
		JSONObject result = new JSONObject();
		Admin admin2 = (Admin)bookRegistrationService.get(admin);
		result.put("admin", admin2);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method= RequestMethod.POST)
	public JSONObject update(Admin admin){
		JSONObject result = new JSONObject();
		boolean flag = bookRegistrationService.update(admin);
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/booksInPage",method = RequestMethod.GET)
	public JSONObject getAll(int pageNum){
		
		JSONObject result = new JSONObject();
		List<BookRegistration> books = (List<BookRegistration>) bookRegistrationService.getAll();
		result.put("array", books);
		return result;
	}
	
	
}
