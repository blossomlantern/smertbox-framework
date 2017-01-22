package com.smertbox.security.user.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.smertbox.security.resource.model.SysResources;

public class SecurityUser extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * @param username 用户名
	 * @param password 密码
	 * @param enabled 用户是否可用
	 * @param accountNonExpired 用户账号是否过期
	 * @param credentialsNonExpired 用户密码是否过期
	 * @param accountNonLocked 用户账号是否被锁定
	 * @param authorities 用户拥有的权限
	 */
	public SecurityUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,SysUser sysUser,List<SysResources> resources) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.sysUser = sysUser;
		this.resources = resources!=null ? resources : new ArrayList<SysResources>();
	}
	
	private SysUser sysUser;
	
	private List<SysResources> resources ;

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public List<SysResources> getResources() {
		return resources;
	}

	public void setResources(List<SysResources> resources) {
		this.resources = resources;
	}

}
