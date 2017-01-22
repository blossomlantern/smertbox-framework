package com.smertbox.security.core.util;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Author : ladeng
 * Time: 2016年9月24日 下午4:13:44
 * Desc : Spring Security工具类 用于获取用户相关数据
 */
public class SecurityUtil {

	/**
	 * @description 获取当前登录用户id
	 * @return
	 */
	public static String getCurrentUserName() throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		if (principal instanceof Principal) {
			return ((Principal) principal).getName();
		}
		
		return String.valueOf(principal);
	}
	
	public static Object getCurrentUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return principal;
	}
}
