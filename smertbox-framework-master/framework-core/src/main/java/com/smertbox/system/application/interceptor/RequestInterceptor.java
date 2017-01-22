package com.smertbox.system.application.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.smertbox.system.application.ApplicationContext;

/**
 * Author : ladeng
 * Time: 2016年8月28日 下午8:07:51
 * Desc : 请求拦截,放入一些系统全局变量,及拦截处理.
 */
public class RequestInterceptor extends HandlerInterceptorAdapter{

	private static Logger logger = Logger.getLogger(RequestInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.getSession().setAttribute("AppCNName", ApplicationContext.applicationCNName);
		request.getSession().setAttribute("AppENName", ApplicationContext.applicationENName);
		logger.debug("RequestInterceptor");
		return true;
		
	}
	
}
