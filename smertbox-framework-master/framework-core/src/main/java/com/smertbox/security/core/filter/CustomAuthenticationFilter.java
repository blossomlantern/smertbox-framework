package com.smertbox.security.core.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.code.kaptcha.Constants;
import com.smertbox.security.core.exception.KaptchaException;
import com.smertbox.security.core.handler.KaptchaHandler;
import com.smertbox.util.properties.PropertiesUitl;

/**
 * Author : ladeng
 * Time: 2016年8月26日 下午11:48:35
 * Desc : Kaptcha 验证码验证登录过滤器 .继承spring security默认验证过滤器,将用户校验依然交由spring security处理.
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private static String SPRING_SECURITY_FORM_KAPTCHA_KEY = "kaptchaValue";
	
	private AuthenticationFailureHandler kaptchaHandler = new KaptchaHandler();
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
	    if(!"true".equals(PropertiesUitl.getInstance().getSystemProperty("system.debug"))){
	    	String kaptchaValue = obtainKaptcha(request).toLowerCase();
			String kaptchaKey = obtainGeneratedKaptcha(request).toLowerCase();
			if(StringUtils.isBlank(kaptchaValue)){
				try{
					throw new KaptchaException("验证码验证为空!");
				}catch(AuthenticationException failed){
					try {
						kaptchaHandler.onAuthenticationFailure(request, response, failed);
						return null;
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ServletException e) {
						e.printStackTrace();
					}
				}
			}
			if(!kaptchaValue.equals(kaptchaKey)){
				try{
					throw new KaptchaException("验证码验证不正确!");
				}catch(AuthenticationException failed){
					try {
						kaptchaHandler.onAuthenticationFailure(request, response, failed);
						return null;
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ServletException e) {
						e.printStackTrace();
					}
				}
			}
	    }
	    
		return super.attemptAuthentication(request, response);
	}

	protected String obtainKaptcha(HttpServletRequest request){  
        return request.getParameter(SPRING_SECURITY_FORM_KAPTCHA_KEY);  
    }  
      
    protected String obtainGeneratedKaptcha (HttpServletRequest request){  
        return (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);  
    }

	public AuthenticationFailureHandler getKaptchaHandler() {
		return kaptchaHandler;
	}

	public void setKaptchaHandler(AuthenticationFailureHandler kaptchaHandler) {
		this.kaptchaHandler = kaptchaHandler;
	}


}
