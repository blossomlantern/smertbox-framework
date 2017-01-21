package com.smertbox.security.userrole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.userrole.mapper.SysUserRoleMapper;
import com.smertbox.security.userrole.model.SysUserRole;

@Service
public class UserRoleService {

	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	
	public SysUserRole selectByPrimaryKey(String id){
		
		return sysUserRoleMapper.selectByPrimaryKey(id);
	}

	public List<SysUserRole> selectPage(SysUserRole sysUserRole) {
		
		return sysUserRoleMapper.selectPage(sysUserRole);
	}

	public int selectPageSize(SysUserRole sysUserRole) {
		
		return sysUserRoleMapper.selectPageSize(sysUserRole);
	}

	public void insert(SysUserRole sysUserRole) {
		
		sysUserRoleMapper.insertSelective(sysUserRole);
	}

	public void update(SysUserRole sysUserRole) {
		
		sysUserRoleMapper.updateByPrimaryKeySelective(sysUserRole);
	}

	public void delete(String id){
		
		sysUserRoleMapper.deleteByPrimaryKey(id);
	}

	public void deleteByUserId(String userId) {
		
		sysUserRoleMapper.deleteByUserId(userId);
	}
}
