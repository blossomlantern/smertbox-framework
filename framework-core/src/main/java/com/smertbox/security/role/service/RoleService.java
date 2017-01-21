package com.smertbox.security.role.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.role.mapper.SysRoleMapper;
import com.smertbox.security.role.model.SysRole;

@Service
public class RoleService {

	@Autowired
	SysRoleMapper sysRoleMapper;
	
	public SysRole selectByPrimaryKey(String id){
		
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	public List<SysRole> selectPageData(SysRole sysRole) {
		
		return sysRoleMapper.selectPageData(sysRole);
	}

	public int selectPageDataSize(SysRole sysRole) {
		
		return sysRoleMapper.selectPageDataSize(sysRole);
	}

	public void insert(SysRole sysRole) {
		
		sysRoleMapper.insertSelective(sysRole);
	}

	public void update(SysRole sysRole) {
		
		sysRoleMapper.updateByPrimaryKeySelective(sysRole);
	}
	
	public List<SysRole> selectPageByOrgId(Set<String> orgs) {
		if(orgs == null || orgs.size() == 0){
			return null;
		}
		return sysRoleMapper.selectPageByOrgId(orgs);
	}

}
