package com.smertbox.security.core.handler;

import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.smertbox.security.core.util.SecurityUtil;
import com.smertbox.security.log.model.SysLog;
import com.smertbox.security.log.service.LogRedisService;
import com.smertbox.security.user.model.SysUser;
import com.smertbox.security.user.service.UserService;
import com.smertbox.util.network.NetworkUtil;

/**
 * @author:ladeng
 * @time:2016年11月27日 下午3:12:00
 * @description:当登陆成功时进行处理记录，将用户的登录时间记录到数据库。
 */
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	private Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);
	
	@Autowired
	UserService userService;
	@Autowired
	LogRedisService logRedisService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		try{
			String loginAccount = SecurityUtil.getCurrentUserName();
			if(StringUtils.isNotBlank(loginAccount)){
				// 记录登录时间
				SysUser user = userService.selectByLoginAccount(loginAccount);
				if(user != null){
					user.setLastLoginTime(user.getLoginTime());
					user.setLoginTime(Calendar.getInstance().getTime());
					userService.update(user);
				}
				
				//记录登录日志
				String requestUrl = request.getRequestURL().toString();
				String ipAddress = NetworkUtil.getIpAddress(request);
				String userName = user.getUsername();
				String urlName = "系统登录";
				
				SysLog log = new SysLog();
				log.setLogId(UUID.randomUUID().toString());
				log.setUserId(loginAccount);
				log.setResUrl(requestUrl);
				log.setOpTime(Calendar.getInstance().getTime());
				log.setUserName(userName != null ? userName : "No login request.");
				log.setOpContent(urlName);
				log.setExtend1(ipAddress);
				log.setExtend2("[authentication success/认证成功]");
				logRedisService.push(log);
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
}
