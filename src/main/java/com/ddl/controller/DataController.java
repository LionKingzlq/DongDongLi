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

import com.ddl.model.Data;
import com.ddl.service.IDataService;
import com.ddl.util.FileOperateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/data")
public class DataController {
	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	@Resource(name="fileOperateUtil")
	private FileOperateUtil fileOperateUtil;
	
	@Resource
	private IDataService dataService;
	
	@ResponseBody
	@RequestMapping(value="datasInPage", method = RequestMethod.GET)
	public JSONObject getAllDatas(int pageNum){
		@SuppressWarnings("unchecked")
		List<Data> datas = (List<Data>) dataService.getAll();
		JSONObject result = new JSONObject();
		result.put("array", JSONArray.fromObject(datas));
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method = RequestMethod.POST)
	public JSONObject update(Data data){
		boolean flag = dataService.update(data);
		JSONObject result = new JSONObject();
		result.put("data", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method = RequestMethod.GET)
	public JSONObject get(Data data){
		Data object = (Data)dataService.get(data);
		JSONObject result = new JSONObject();
		result.put("data", object);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method = RequestMethod.GET)
	public JSONObject delete(Data data){
		boolean flag = dataService.delete(data);
		JSONObject result = new JSONObject();
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "dataAddList", method = RequestMethod.POST)
	public JSONObject memberAddList(HttpServletRequest request) {
		JSONObject result = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			String filePath = fileOperateUtil.upLoadFile(request, false);
			int num = dataService.saveAll(filePath);
			result.put("code", "200");
			result.put("num", num);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			result.put("code", "400");
		}
		return result;
	}
}
