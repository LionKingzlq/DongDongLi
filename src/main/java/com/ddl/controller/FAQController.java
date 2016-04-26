package com.ddl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ddl.model.FAQ;
import com.ddl.service.IFAQService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/faq")
public class FAQController {

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
	
	
}
