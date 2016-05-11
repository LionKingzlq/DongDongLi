package com.ddl.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddl.model.Data;
import com.ddl.service.IDataService;
import com.ddl.service.IFAQService;
import com.ddl.service.IInstructionAddressService;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value="")
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource
	private IDataService dataService;
	
	@Resource
	private IFAQService faqService;
	
	@Resource
	private IInstructionAddressService instructionAddressService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("faqs",faqService.getAll());
		model.addAttribute("addresses",instructionAddressService.getAll());
		return "index";
	}
	
}
