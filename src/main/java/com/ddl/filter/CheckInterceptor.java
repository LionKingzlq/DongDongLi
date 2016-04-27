package com.ddl.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CheckInterceptor implements HandlerInterceptor{

	private final Logger log = LoggerFactory.getLogger(CheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//		return true;
		
		log.info("==============执行顺序: 1、preHandle================");    
        String requestUri = request.getRequestURI();  
        String contextPath = request.getContextPath();  
        String url = requestUri.substring(contextPath.length());  
        
        Object adminId =  request.getSession().getAttribute("adminId");   
        if(adminId == null){
        	if(url.equals("/admin") || url.equals("/admin/login")){
        		return true;
        	}
            log.info("Interceptor：跳转到login页面！");
            request.getRequestDispatcher("/admin").forward(request, response);  
            return false;
        }else
            return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
