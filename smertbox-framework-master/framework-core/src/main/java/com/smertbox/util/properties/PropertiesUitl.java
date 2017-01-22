package com.smertbox.util.properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.smertbox.constant.Constant;

/**
 * Author : ladeng
 * Time: 2016年8月13日 下午11:19:49
 * Desc : 读取属性文件 只读取在classes根目录下的属性文件
 */
public class PropertiesUitl {

	private Logger logger = Logger.getLogger(PropertiesUitl.class);
	
	private static PropertiesUitl instance = null;
	
	public PropertiesUitl() {}

	public static PropertiesUitl getInstance() {
		if (instance == null) {
			instance = new PropertiesUitl();
		}
		return instance;
	}

	/**
	 * @description 获取系统属性文件属性
	 * @param key
	 * @return
	 */
	public String getSystemProperty(String key) {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(PropertiesUitl.class.getClassLoader().getResourceAsStream(Constant.DefaultPropertyFileName), "utf-8") ;
			Properties properties = new Properties();
			properties.load(inputStreamReader);
			logger.debug("读取系统配置文件成功!");
			inputStreamReader.close();
			return (String) properties.get(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @description 获取自定义属性文件属性
	 * @param propertyFile
	 * @param key
	 * @return
	 */
	public String getProperty(String propertyFile,String key) {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(PropertiesUitl.class.getClassLoader().getResourceAsStream(propertyFile), "utf-8") ;
			Properties properties = new Properties();
			properties.load(inputStreamReader);
			logger.debug("读取"+propertyFile+"文件成功!");
			inputStreamReader.close();
			return (String) properties.get(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
