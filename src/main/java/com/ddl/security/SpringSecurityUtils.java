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
	 * 取得当前登录所属的机构名称  商酷
	 * 集团商户~~~admin~~~2045100001~~~999451044680001~~~342~~~3
	 *@return 集团商户
	 */
	public static String getCurrentUserOrgName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		String[] namesInfo = name.split("~~~");
		return namesInfo[0];
	}

	/**
	 * 取得当前登录时用户名  admin
	 * 商酷~~~admin~~~1~~~99990000~~~1
	 * @return admin
	 */
	public static String getCurrentLoginName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		String[] namesInfo = name.split("~~~");
		return namesInfo[1];
	}

	/**
	 * 取得当前登录商户的机构号
	 * 集团商户~~~admin~~~2045100001~~~999451044680001~~~342~~~3
	 * @return 999451044680001
	 */
	public static String getCurrentMerId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		String[] namesInfo = name.split("~~~");
		return namesInfo[3];
	}

	/**
	 * 取得当前用户的内部id号
	 * 集团商户~~~admin~~~2045100001~~~999451044680001~~~342~~~3
	 * @return 342
	 */
	public static String getCurrentUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		String[] namesInfo = name.split("~~~");
		return namesInfo[4];
	}
	
	/**
	 * 取得当前登录的机构号
	 * 集团商户~~~admin~~~2045100001~~~999451044680001~~~342~~~3
	 * @return 2045100001
	 */
	public static String getCurrentOrg() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		String[] namesInfo = name.split("~~~");
		return namesInfo[2];
	}
	
	/**
	 * 取得当前登录的商户级别
	 * 集团商户~~~admin~~~2045100001~~~999451044680001~~~342~~~3
	 * @return 2045100001
	 */
	public static String getCurrentMerLevel() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		String[] namesInfo = name.split("~~~");
		return namesInfo[5];
	}
	
	/**
	 * 取得当前登录的商户币种
	 * 集团商户~~~admin~~~2045100001~~~999451044680001~~~342~~~3~~~CNY
	 * @return 2045100001
	 */
	public static String getCurType() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "";
		}
		String name = auth.getName();
		String[] namesInfo = name.split("~~~");
		return namesInfo[6];
	}
	
	public static String getCurSymbol(){
		return getCurType();
	}
	
	
	public static String getStlmtLev(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return "0";
		}
		String name = auth.getName();
		String[] namesInfo = name.split("~~~");
		return namesInfo[7];
	}
	
	public static Long getLoginCount() {
		String userId = getCurrentUserId();
		if("".equals(userId)){
			return 0l;
		}
		Long loginCount = (long) 0;
		return loginCount;
	}

}