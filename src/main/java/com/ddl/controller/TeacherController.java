package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddl.model.Teacher;
import com.ddl.service.ITeacherService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

	@Resource
	private ITeacherService teacherService;
	
	@ResponseBody
	@RequestMapping(value="teachersInPage", method = RequestMethod.GET)
	public JSONObject getAllTeachers(int pageNum){
		@SuppressWarnings("unchecked")
		List<Teacher> teachers = (List<Teacher>) teacherService.getAll();
		JSONObject result = new JSONObject();
		result.put("array", JSONArray.fromObject(teachers));
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method = RequestMethod.POST)
	public JSONObject update(Teacher teacher){
		boolean flag = teacherService.update(teacher);
		JSONObject result = new JSONObject();
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method = RequestMethod.GET)
	public JSONObject get(Teacher teacher){
		Teacher object = (Teacher)teacherService.get(teacher);
		JSONObject result = new JSONObject();
		result.put("teacher", object);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method = RequestMethod.GET)
	public JSONObject delete(Teacher teacher){
		boolean flag = teacherService.delete(teacher);
		JSONObject result = new JSONObject();
		result.put("flag", flag);
		return result;
	}
	
}
