package com.smertbox.security.core.filter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.smertbox.security.core.util.SecurityUtil;
import com.smertbox.security.log.model.SysLog;
import com.smertbox.security.log.service.LogRedisService;
import com.smertbox.security.user.model.SecurityUser;
import com.smertbox.util.network.NetworkUtil;
import com.smertbox.util.properties.PropertiesUitl;

public class CustomFilterSecurityInterceptor extends FilterSecurityInterceptor {

	private static Logger logger = Logger.getLogger(CustomFilterSecurityInterceptor.class);
	
	@Autowired
	LogRedisService logRedisService;
	@Autowired
	CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		String requestUrl = fi.getRequestUrl();
		PathMatcher matcher = new AntPathMatcher();
		String urls = PropertiesUitl.getInstance().getProperty("spring-security/security.properties", "security.content.type.url");
		if(urls != null && StringUtils.isNotBlank(urls)){
			String[] url = urls.split(",");
			boolean exist = false;
			for (int i = 0; i < url.length; i++) {
				if(matcher.match(url[i], requestUrl)){
					exist = true;
					break;
				}
			}
			
			if(exist){
				response.setContentType("text/html");
			}
		}
		
		try{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String userName = null;
			String urlName = null;
			if(authentication != null && authentication.isAuthenticated()){
				SecurityUser user = (SecurityUser) authentication.getPrincipal();
				userName = user.getSysUser().getUsername();
			}
			Collection<ConfigAttribute> value = customFilterInvocationSecurityMetadataSource.getAttributesByUrl(requestUrl);
			if(value != null){
				for (ConfigAttribute configAttribute : value) {
					urlName = configAttribute.getAttribute();
					if(StringUtils.isNotBlank(urlName)){
						break;
					}
				}
			}
			
			String ipAddress = NetworkUtil.getIpAddress((HttpServletRequest) request);
			SysLog log = new SysLog();
			log.setLogId(UUID.randomUUID().toString());
			log.setOpTime(Calendar.getInstance().getTime());
			log.setUserId(SecurityUtil.getCurrentUserName());
			log.setUserName(userName != null ? userName : "No login request.");
			log.setResUrl(requestUrl);
			log.setOpContent(urlName);
			log.setExtend1(ipAddress);
			logRedisService.push(log);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		
		super.doFilter(request, response, chain);
	}
}
