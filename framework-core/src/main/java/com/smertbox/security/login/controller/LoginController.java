package com.smertbox.security.login.controller;

import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.smertbox.security.log.model.SysLog;
import com.smertbox.security.log.service.LogRedisService;
import com.smertbox.security.login.service.LoginService;
import com.smertbox.util.network.NetworkUtil;

/**
 * Author : ladeng
 * Time: 2016年6月10日 上午12:12:15
 * Desc : 登录界面跳转处理
 */
@Controller()
@RequestMapping("/sign")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MessageSource messageSource;
	@Autowired
	LoginService loginService;
	@Autowired
	LogRedisService logRedisService;
	
	@RequestMapping("/inpage")
	public String loginPage(HttpServletRequest request,Model model,HttpSession session){
		//String error = (String) request.getSession().getAttribute("error");
		return "login";
	}
	
	@RequestMapping(value="/in")
	public String in(HttpServletRequest request,RedirectAttributes redirectAttributes){
		String error = request.getParameter("error");
		if(StringUtils.isNotBlank(error)){
			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);  
			String message = messageSource.getMessage(error, null, locale);
			request.getSession().setAttribute("error", error);
			request.getSession().setAttribute("message", message);
		}
		return "redirect:inpage";
	}
	
	/**
	 * description:退出登录
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response,Model model){
		try{
			//记录日志
			String loginAccount = request.getParameter("loginAccount");
			if(StringUtils.isNotBlank(loginAccount)){
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
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "redirect:/sign/in?error=logout";
	}
}
