package com.smertbox.security.core;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.smertbox.util.date.DateUtil;

/**
 * Author : ladeng
 * Time: 2016年8月12日 上午12:09:50
 * Desc :权限访问决策管理器
 */
@Service
public class CustomAccessDecisionManager implements AccessDecisionManager {
	
	private static final Logger logger = Logger.getLogger(CustomAccessDecisionManager.class); 

	@Override
	public void decide(Authentication authentication, Object object,Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		if(logger.isDebugEnabled()){
			logger.debug(DateUtil.currentStrTime()+" 请求的url是:"+object.toString());
		}
		
		//通过循环查找权限列表中是否存在请求的权限
        Iterator<ConfigAttribute> iter = configAttributes.iterator();        
        while(iter.hasNext()){
            ConfigAttribute configAttribute = iter.next();//权限属性
            String needRole = ((SecurityConfig) configAttribute).getAttribute();//所需权限
            for (GrantedAuthority grant : authentication.getAuthorities()) {
                if (needRole.trim().equals(grant.getAuthority().trim())) {
                    return;
                }
            }
        }
        //无权限抛出异常
        throw new AccessDeniedException("Access Denied");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
