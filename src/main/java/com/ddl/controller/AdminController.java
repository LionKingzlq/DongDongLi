package com.ddl.controller;

import javax.annotation.Resource;

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
	private IAdminService adminServer;
	
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
	public JSONObject check(Model model, Admin admin){
		JSONObject result = new JSONObject();
		boolean flag = adminServer.checkAdmin(admin);
		result.put("result", flag);
		return result;
	}
}
