package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ddl.model.Admin;
import com.ddl.service.IAdminService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Resource
	private IAdminService adminService;
	
	@RequestMapping(value="")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="index")
	public String Index(){
		return "admin/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public JSONObject check(Model model, Admin admin, HttpSession session){
		JSONObject result = new JSONObject();
		int adminId = adminService.checkAdmin(admin);
		result.put("result", adminId);
		session.setAttribute("adminId", adminId);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="add",method= RequestMethod.POST)
	public JSONObject add(Admin admin){
		JSONObject result = new JSONObject();
		boolean flag = adminService.save(admin);
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method= RequestMethod.POST)
	public JSONObject delete(Admin admin){
		JSONObject result = new JSONObject();
		boolean flag = adminService.delete(admin);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method= RequestMethod.GET)
	public JSONObject get(Admin admin){
		JSONObject result = new JSONObject();
		Admin admin2 = (Admin)adminService.get(admin);
		result.put("admin", admin2);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method= RequestMethod.POST)
	public JSONObject update(Admin admin){
		JSONObject result = new JSONObject();
		boolean flag = adminService.update(admin);
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/adminsInPage",method = RequestMethod.GET)
	public JSONObject getAll(int pageNum){
		
		JSONObject result = new JSONObject();
		List<Admin> admins = (List<Admin>) adminService.getAll();
		result.put("array", admins);
		return result;
	}
	
	
}
