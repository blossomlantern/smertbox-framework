package com.smertbox.system.application.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Author : ladeng
 * Time: 2016年8月28日 下午8:07:51
 * Desc : 响应拦截,放入跨域访问限制消息头.
 * 	X-Frame-Options 有三个值:
 * 	DENY
 * 	表示该页面不允许在 frame 中展示，即便是在相同域名的页面中嵌套也不允许。
 * 	SAMEORIGIN
 * 	表示该页面可以在相同域名页面的 frame 中展示。
 * 	ALLOW-FROM uri
 * 	表示该页面可以在指定来源的 frame 中展示。
 */
public class ResponseInterceptor extends HandlerInterceptorAdapter{

	private static Logger logger = Logger.getLogger(ResponseInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 相同域名允许访问
//		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		logger.debug("ResponseInterceptor");
		return true;
	}
	
}
