package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddl.model.Data;
import com.ddl.service.IDataService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/data")
public class DataController {

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
	
}
