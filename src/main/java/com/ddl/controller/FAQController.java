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

import com.ddl.model.FAQ;
import com.ddl.service.IFAQService;
import com.ddl.util.FileOperateUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/faq")
public class FAQController {
	
	private static final Logger logger = LoggerFactory.getLogger(FAQController.class);
	@Resource(name="fileOperateUtil")
	private FileOperateUtil fileOperateUtil;
	
	@Resource
	private IFAQService faqService;
	
	@ResponseBody
	@RequestMapping(value="add",method= RequestMethod.POST)
	public JSONObject add(FAQ faq){
		JSONObject result = new JSONObject();
		boolean flag = faqService.save(faq);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method= RequestMethod.POST)
	public JSONObject delete(FAQ faq){
		JSONObject result = new JSONObject();
		boolean flag = faqService.delete(faq);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method= RequestMethod.GET)
	public JSONObject get(FAQ faq){
		JSONObject result = new JSONObject();
		FAQ faq2 = (FAQ)faqService.get(faq);
		result.put("faq", faq2);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method= RequestMethod.POST)
	public JSONObject update(FAQ faq){
		JSONObject result = new JSONObject();
		boolean flag = faqService.update(faq);
		result.put("flag", flag);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/faqInPage",method = RequestMethod.GET)
	public JSONObject getAll(int pageNum){
		JSONObject result = new JSONObject();
		List<FAQ> faqs = (List<FAQ>) faqService.getAll();
		result.put("array", faqs);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/addList",method = RequestMethod.GET)
	public JSONObject addList(HttpServletRequest request){
		JSONObject result = new JSONObject();
		List<FAQ> faqs = (List<FAQ>) faqService.getAll();
		result.put("array", faqs);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "faqAddList", method = RequestMethod.POST)
	public JSONObject memberAddList(HttpServletRequest request) {
		JSONObject result = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			String filePath = fileOperateUtil.upLoadFile(request);
			int num = faqService.saveAll(filePath);
			result.put("code", "200");
			result.put("num", num);
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
			FAQ faq = new FAQ();
			faq.setId(id);
			faqService.delete(faq);
		}
	}
}
