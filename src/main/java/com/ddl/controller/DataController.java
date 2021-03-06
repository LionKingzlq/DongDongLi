package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ddl.security.SpringSecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddl.model.Data;
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
	@RequestMapping(value="delete",method = RequestMethod.POST)
	public JSONObject delete(Data data){
		boolean flag = dataService.delete(data);
		JSONObject result = new JSONObject();
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "dataAddList", method = RequestMethod.POST)
	public JSONObject memberAddList(HttpServletRequest request) {

		int adminId = Integer.valueOf(SpringSecurityUtils.getCurrentId());
		JSONObject result = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			String filePath = fileOperateUtil.upLoadFile(request);
			int num = dataService.saveAll(filePath, adminId);
			result.put("code", "200");
			result.put("num", num);
			
			String[] fileName = filePath.split("/");
			fileOperateUtil.deleteFile(fileName[fileName.length - 1]);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			result.put("code", "400");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteMore",method = RequestMethod.POST)
	public void deleteMore(int[] ids){
		for (int id:ids) {
			Data data = new Data();
			data.setId(id);
			dataService.delete(data);
		}
	}

	//上传一些字典中的图片，实现参数可配置
	@ResponseBody
	@RequestMapping(value = "upload")
	public JSONObject upload(HttpServletRequest request) {
		String filePath = "data_" + request.getParameter("id") + ".png";
		JSONObject result = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			filePath = fileOperateUtil.upLoadFile(request, filePath);
			System.out.println(filePath);
			
			String[] fileName = filePath.split("/");
			result.put("content", fileName[fileName.length - 1]);
			result.put("code", 200);
		} catch (Exception e) {
			result.put("code", 400);
		}
		return result;
	}
}
