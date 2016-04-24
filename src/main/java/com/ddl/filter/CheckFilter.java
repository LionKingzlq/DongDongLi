package com.ddl.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CheckFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String headerUserAgent = request.getHeader("User-Agent");
		System.out.println("user-agent:"+headerUserAgent);
	    
		
        filterChain.doFilter(request, response);
        
        System.out.println("after");
        return;   
	}

}
