package com.smertbox.security.roleprivilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.roleprivilege.mapper.SysRolePrivilegeMapper;
import com.smertbox.security.roleprivilege.model.SysRolePrivilege;

@Service
public class RolePrivilegeService {

	@Autowired
	SysRolePrivilegeMapper sysRolePrivilegeMapper;
	
	public void insert(SysRolePrivilege sysRolePrivilege){
		
		sysRolePrivilegeMapper.insertSelective(sysRolePrivilege);
	}
	
	public void update(SysRolePrivilege sysRolePrivilege){
		
		sysRolePrivilegeMapper.updateByPrimaryKeySelective(sysRolePrivilege);
	}
	
	public SysRolePrivilege selectByPrimaryKey(String id){
		
		return sysRolePrivilegeMapper.selectByPrimaryKey(id);
	}
	
	public List<SysRolePrivilege> selectPage(SysRolePrivilege sysRolePrivilege){
		
		return sysRolePrivilegeMapper.selectPage(sysRolePrivilege);
	}
	
	public void deleteByRoleId(String roleId){
		sysRolePrivilegeMapper.deleteByRoleId(roleId);
	}
}
