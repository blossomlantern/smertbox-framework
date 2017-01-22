package com.smertbox.security.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.user.mapper.SysUserMapper;
import com.smertbox.security.user.model.SysUser;

@Service
public class LoginService {
	
	@Autowired
	SysUserMapper sysUserMapper;
	
	SysUser findBystUsername(){
		
		return null;
	}
	
	public boolean insertOne(SysUser user){
		sysUserMapper.insert(user);
		return true;
	}

}
