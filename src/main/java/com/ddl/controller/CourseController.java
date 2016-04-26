package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ddl.model.Course;
import com.ddl.service.ICourseService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/course")
public class CourseController {

	@Resource
	private ICourseService courseService;
	
	@ResponseBody
	@RequestMapping(value="add",method= RequestMethod.POST)
	public JSONObject add(Course course){
		JSONObject result = new JSONObject();
		boolean flag = courseService.save(course);
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method= RequestMethod.POST)
	public JSONObject delete(Course course){
		JSONObject result = new JSONObject();
		boolean flag = courseService.delete(course);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method= RequestMethod.GET)
	public JSONObject get(Course course){
		JSONObject result = new JSONObject();
		Course course2 = (Course)courseService.get(course);
		result.put("course", course2);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method= RequestMethod.POST)
	public JSONObject update(Course course){
		JSONObject result = new JSONObject();
		boolean flag = courseService.update(course);
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/coursesInPage",method = RequestMethod.GET)
	public JSONObject getAll(int pageNum){
		
		JSONObject result = new JSONObject();
		List<Course> courses = (List<Course>) courseService.getAll();
		result.put("array", courses);
		return result;
	}
	
	
}
