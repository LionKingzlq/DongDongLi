package com.ddl.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * SpringSecurity的工具类.
 * 
 * @author wangwch
 */
public class SpringSecurityUtils {

	/**
	 * 取得当前用户的登录名,如果当前用户未登录则返回空字符串.
	 */
	public static String getCurrentUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		
		return auth.getName();
	}

	/**
	 * 取得当前用户,返回值为SpringSecurity的User类及其子类, 如果当前用户未登录则返回null.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends User> T getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal == null) {
			return null;
		}
		return (T) principal;
	}

	/**
	 * 取得当前登录管理员id
	 * id:adminName
	 *@return 集团商户
	 */
	public static int getCurrentId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return 0;
		}
		String name = auth.getName();
		String[] namesInfo = name.split(":");
		return Integer.valueOf(namesInfo[0]);
	}

	/**
	 * 取得当前登录时用户名adminName
	 * id:adminName
	 * @return admin
	 */
	public static String getCurrentName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		String[] namesInfo = name.split(":");
		return namesInfo[1];
	}

	public static Long getLoginCount() {
		int adminId = getCurrentId();
		if(adminId == 0){
			return 0l;
		}
		Long loginCount = (long) 0;
		return loginCount;
	}

}