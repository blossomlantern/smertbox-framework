package com.smertbox.security.core.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.resource.service.ResourcesService;

/**
 * Author : ladeng
 * Time: 2016年8月12日 上午12:08:35
 * Desc :权限/资源对应关系访问
 */
@Service
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	private static final Logger logger = Logger.getLogger(CustomFilterInvocationSecurityMetadataSource.class); 
	
	private static HashMap<String, Collection<ConfigAttribute>> resourceMap = null; 
	
	@Autowired
	ResourcesService resourcesService;
	
	/**
	 * @description 在初始化bean前执行这个方法
	 */
    @PostConstruct	    
    public void init() {  
        loadResourceDefine();  
    }
    
    public void reloadResource(){
    	this.loadResourceDefine();
    }
    
    private void loadResourceDefine() {
    	// 在Web服务器启动时 ，提取系统中的所有权限。      
        List<SysResources> sysResourcesList = resourcesService.selectAll();  
          
        //应当是资源为key， 权限为value。  一个资源可以由多个权限来访问。             
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  
         
        ConfigAttribute configAttribute = null;
        for (SysResources sysResources : sysResourcesList) {      
            String resourceName = sysResources.getResName();     
            configAttribute = new SecurityConfig(resourceName); 
            String url = sysResources.getResUrl();
            //判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。                     
            if (resourceMap.containsKey(url)) { 
                Collection<ConfigAttribute> value = resourceMap.get(url);  
                value.add(configAttribute);  
                resourceMap.put(url, value);  
            } else {
                Collection<ConfigAttribute> value = new ArrayList<ConfigAttribute>();  
                value.add(configAttribute);  
                resourceMap.put(url, value);  
            }  
        }  
    }
    
    /**
     * 根据URL获取该权限的配置
     */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		
		if(requestUrl.contains("?")){
			requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
		}
		
		if(resourceMap == null) {
			loadResourceDefine();
		}
		
		return resourceMap.get(requestUrl);
	}
	
	public Collection<ConfigAttribute> getAttributesByUrl(String requestUrl) throws IllegalArgumentException {
		if(requestUrl.contains("?")){
			requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
		}
		
		if(resourceMap == null) {
			loadResourceDefine();
		}
		
		return resourceMap.get(requestUrl);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
