package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ddl.model.BookRegistration;
import com.ddl.model.Teacher;
import com.ddl.service.IBookRegistrationService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/book")
public class BookRegistrationController {

	@Resource
	private IBookRegistrationService bookRegistrationService;
	
	@ResponseBody
	@RequestMapping(value="add",method= RequestMethod.POST)
	public JSONObject add(BookRegistration BookRegistration){
		JSONObject result = new JSONObject();
		boolean flag = bookRegistrationService.save(BookRegistration);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method= RequestMethod.POST)
	public JSONObject delete(BookRegistration BookRegistration){
		JSONObject result = new JSONObject();
		boolean flag = bookRegistrationService.delete(BookRegistration);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method= RequestMethod.GET)
	public JSONObject get(BookRegistration BookRegistration){
		JSONObject result = new JSONObject();
		BookRegistration BookRegistration2 = (BookRegistration)bookRegistrationService.get(BookRegistration);
		result.put("BookRegistration", BookRegistration2);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method= RequestMethod.POST)
	public JSONObject update(BookRegistration BookRegistration){
		JSONObject result = new JSONObject();
		boolean flag = bookRegistrationService.update(BookRegistration);
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
	
	@ResponseBody
	@RequestMapping(value="/deleteMore",method = RequestMethod.POST)
	public void deleteMore(int[] ids){
		for (int id:ids) {
			BookRegistration book = new BookRegistration();
			book.setId(id);
			bookRegistrationService.delete(book);
		}
	}
}
