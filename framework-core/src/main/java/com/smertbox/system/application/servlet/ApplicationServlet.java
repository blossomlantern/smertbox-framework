package com.smertbox.system.application.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.smertbox.system.application.ApplicationContext;
import com.smertbox.util.properties.PropertiesUitl;

/**
 * Author : ladeng
 * Time: 2016年8月14日 下午9:24:24
 * Desc :初始化系统参数 eg:项目路径等
 */
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(ApplicationServlet.class);
	
	@Override
	public void init() throws ServletException {
		String applicationPath = this.getServletContext().getRealPath("\\").replace("\\", "/");
		// 初始化设置项目根路径
		ApplicationContext.applicationRootPath = applicationPath;
		logger.debug("系统初始化项目地址："+applicationPath);
		// 初始化设置项目WEB-INF路径
		ApplicationContext.applicationWEBINFPath = applicationPath+"WEB-INF/";
		// 初始化设置项目名称 从配置文件获得
		ApplicationContext.applicationCNName = PropertiesUitl.getInstance().getSystemProperty("application.cn.name");
		ApplicationContext.applicationENName = PropertiesUitl.getInstance().getSystemProperty("application.en.name");
	}
}
