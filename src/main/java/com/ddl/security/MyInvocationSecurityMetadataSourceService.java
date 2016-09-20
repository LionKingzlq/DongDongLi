package com.ddl.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.abraham.dj.dao.UserDao;

public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	@Resource
	private UserDao userDao;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	public MyInvocationSecurityMetadataSourceService() {
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
			if(userDao != null){
				loadResourceDefine();
			}
			
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

	private void loadResourceDefine() {
		List<String> query = this.userDao.getAuthorityName();
		if(query == null){
			return;
		}
		/*
		 * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
		 * sparta
		 */
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		for (String auth : query) {
			ConfigAttribute ca = new SecurityConfig(auth);

			List<String> query1 = this.userDao.getResource(auth);

			for (String res : query1) {
				String url = res;

				/*
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，
				 * 将权限增加到权限集合中。 sparta
				 */
				if (resourceMap.containsKey(url)) {
					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(ca);
					resourceMap.put(url, value);
				} else {
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(url, atts);
				}
			}
		}
	}
}