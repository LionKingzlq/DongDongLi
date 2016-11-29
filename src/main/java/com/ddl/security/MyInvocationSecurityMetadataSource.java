package com.ddl.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ddl.dao.AdminDao;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Resource
	private AdminDao adminDao;

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	public MyInvocationSecurityMetadataSource() {
//		loadResourceDefine();
	}
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl();
		int firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}

		if(resourceMap == null || resourceMap.size() == 0){
//			if(userDao != null){
//				loadResourceDefine();
//			}
			
			if(resourceMap == null || resourceMap.size() == 0){
				return null;
			}
		}
		Iterator<String> ite = resourceMap.keySet().iterator();

		while (ite.hasNext()) {
			String resURL = ite.next();

			if (url.equals(resURL)) {

				return resourceMap.get(resURL);
			}
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}