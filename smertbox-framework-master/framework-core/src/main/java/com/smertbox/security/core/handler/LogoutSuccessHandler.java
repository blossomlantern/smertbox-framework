package com.smertbox.security.core.handler;

import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.smertbox.security.core.util.SecurityUtil;
import com.smertbox.security.log.model.SysLog;
import com.smertbox.security.log.service.LogRedisService;
import com.smertbox.util.network.NetworkUtil;

public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(LogoutSuccessHandler.class);
	
	@Autowired
	LogRedisService logRedisService;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		try{
			//记录日志
			String loginAccount = SecurityUtil.getCurrentUserName();
			String requestUrl = request.getRequestURL().toString();
			String ipAddress = NetworkUtil.getIpAddress(request);
			SysLog log = new SysLog();
			log.setLogId(UUID.randomUUID().toString());
			log.setUserId(loginAccount);
			log.setResUrl(requestUrl);
			log.setOpTime(Calendar.getInstance().getTime());
			log.setExtend1(ipAddress);
			log.setExtend2("[退出成功]");
			logRedisService.push(log);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		
		response.sendRedirect("/sign/in?error=logout");
	}
	
	

}
