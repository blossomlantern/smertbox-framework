package com.smertbox.security.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.resource.service.ResourcesService;
import com.smertbox.security.user.model.SecurityUser;
import com.smertbox.security.user.model.SysUser;
import com.smertbox.security.user.service.UserService;
import com.smertbox.util.date.DateUtil;

/**
 * Author : ladeng
 * Time: 2016年8月11日 下午11:54:43
 * Desc :Spring Security UserDetailsService接口实现
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	UserService userService;
	@Autowired
	ResourcesService resourcesService;
	
	List<SysResources> resources;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isNotBlank(username)){
			SysUser tmp = new SysUser();
			tmp.setLoginAccount(username);
			SysUser sysUser = userService.selectByLoginAccount(username);
			if(sysUser==null){
				String message = " 用户：["+username +"]不存在";
				if(logger.isDebugEnabled()){
					logger.error(DateUtil.currentStrTime()+message);
				}
				throw new UsernameNotFoundException(message);
			}
			
			Collection<GrantedAuthority> authorities = getUserGrantedAuthorities(sysUser);
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			SecurityUser su = new SecurityUser(sysUser.getLoginAccount(), sysUser.getPasswd(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, sysUser, resources);
			return su;
		}
		return null;
	}
	
	/**
	 * @description 获取用户所属权限
	 * @param user
	 * @return
	 */
	private Set<GrantedAuthority> getUserGrantedAuthorities(SysUser user){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		//List<SysResources> resources = userService.selectByUser(user);
		//resources = userService.selectByUser(user);
		//角色权限资源
		List<SysResources> byRole = resourcesService.selectByUserRole(user.getLoginAccount());
		//职位权限资源
		List<SysResources> byPisition = null;
		// 如果启用角色权限
		if(user.getEnablePosition()==1){
			byPisition = resourcesService.selectByUserPosition(user.getLoginAccount());
		}
		Map<String, SysResources> map = new HashMap<String, SysResources>();
		if(byRole != null && byRole.size() > 0){
			for (int i = 0; i < byRole.size(); i++) {
				map.put(byRole.get(i).getResUrl(), byRole.get(i));
			}
		}
		if(byPisition != null && byPisition.size() > 0){
			for (int i = 0; i < byPisition.size(); i++) {
				map.put(byPisition.get(i).getResUrl(), byPisition.get(i));
			}
		}
		
		resources = new ArrayList<SysResources>();
		resources.addAll(map.values());
		
		Iterator<SysResources> ite = resources.iterator();
		SysResources resource = null;
		while(ite.hasNext()){
			resource = ite.next();
			if(resource!=null){
				authorities.add(new SimpleGrantedAuthority(resource.getResName()));
			}
		}
		return authorities;
	}
}
