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

import com.ddl.model.Teacher;
import com.ddl.service.ITeacherService;
import com.ddl.util.FileOperateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	@Resource
	private ITeacherService teacherService;
	
	@Resource(name="fileOperateUtil")
	private FileOperateUtil fileOperateUtil;
	
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
	@RequestMapping(value = "upload")
	public JSONObject upload(HttpServletRequest request) {
		JSONObject result = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			String filePath = fileOperateUtil.upLoadFile(request,false);
			String[] fileName = filePath.split("/");
			result.put("content", fileName[fileName.length - 1]);
			result.put("code", 200);
		} catch (Exception e) {
			result.put("code", 400);
		}
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
	
	@ResponseBody
	@RequestMapping(value = "teacherAddList", method = RequestMethod.POST)
	public JSONObject memberAddList(HttpServletRequest request) {
		JSONObject result = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			String filePath = fileOperateUtil.upLoadFile(request, false);
			int num = teacherService.saveAll(filePath);
			result.put("code", "200");
			result.put("num", num);
		} catch (Exception e) {
			logger.debug("memberAddList:" + e.getMessage());
			result.put("code", "400");
		}
		return result;
	}
}
