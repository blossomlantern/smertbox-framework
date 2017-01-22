package com.smertbox.security.core.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * Author : ladeng
 * Time: 2016年8月27日 上午10:47:05
 * Desc : 验证码验证失败跳转控制
 */
public class KaptchaHandler implements AuthenticationFailureHandler{

	protected final Log logger = LogFactory.getLog(getClass());
	
	// 失败跳转地址
	private String defaultFailureUrl;
	// 是否服务器跳转 默认重定向跳转
	private boolean forwardToDestination = false;
	
	// 是否允许创建session
	private boolean allowSessionCreation = true;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	public KaptchaHandler(){
		
	}
	
	public KaptchaHandler(String defaultFailureUrl){
		setDefaultFailureUrl(defaultFailureUrl);
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		if (defaultFailureUrl == null) {
			logger.debug("No failure URL set, sending 401 Unauthorized error");

			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"Authentication Failed: 验证码验证失败!");
		}
		else {
			saveException(request, exception);

			if (forwardToDestination) {
				logger.debug("Forwarding to " + defaultFailureUrl);

				request.getRequestDispatcher(defaultFailureUrl)
						.forward(request, response);
			}
			else {
				logger.debug("Redirecting to " + defaultFailureUrl);
				redirectStrategy.sendRedirect(request, response, defaultFailureUrl);
			}
		}
	}
	
	/**
	 * @description 可以将错误信息等放入session中
	 * @param request
	 * @param exception
	 */
	protected final void saveException(HttpServletRequest request,
			AuthenticationException exception) {
		if (forwardToDestination) {
			request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
		}
		else {
			HttpSession session = request.getSession(false);

			if (session != null || allowSessionCreation) {
				request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
						exception);
			}
		}
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public void setForwardToDestination(boolean forwardToDestination) {
		this.forwardToDestination = forwardToDestination;
	}

	public void setAllowSessionCreation(boolean allowSessionCreation) {
		this.allowSessionCreation = allowSessionCreation;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

}
