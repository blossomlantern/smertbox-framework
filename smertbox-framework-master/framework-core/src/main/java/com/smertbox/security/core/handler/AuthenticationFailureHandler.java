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
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.smertbox.security.log.model.SysLog;
import com.smertbox.security.log.service.LogRedisService;
import com.smertbox.security.user.model.SysUser;
import com.smertbox.security.user.service.UserService;
import com.smertbox.util.network.NetworkUtil;
/**
 * @author:ladeng
 * @time:2016年11月27日 下午3:23:13
 * @description:当登陆失败时进行操作，记录下操作日志。
 */
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	@Autowired
	LogRedisService logRedisService;
	@Autowired
	UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(AuthenticationFailureHandler.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		try{
			String loginAccount = request.getParameter("username");
			//String loginAccount = SecurityUtil.getCurrentUserName();
			String userName = "[Not found]";
			String urlName = "系统登录失败";
			String requestUrl = request.getRequestURL().toString();
			String ipAddress = NetworkUtil.getIpAddress(request);
			if(StringUtils.isNotBlank(loginAccount)){
				SysUser user = userService.selectByLoginAccount(loginAccount);
				if(user != null){
					userName = user.getUsername();
				}
			}
			
			//记录日志
			SysLog log = new SysLog();
			log.setLogId(UUID.randomUUID().toString());
			log.setUserId(loginAccount);
			log.setResUrl(requestUrl);
			log.setOpTime(Calendar.getInstance().getTime());
			log.setOpContent(urlName);
			log.setUserName(userName);
			log.setExtend1(ipAddress);
			log.setExtend2("[authentication failure/认证失败]");
			logRedisService.push(log);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		super.onAuthenticationFailure(request, response, exception);
	}

	
}
