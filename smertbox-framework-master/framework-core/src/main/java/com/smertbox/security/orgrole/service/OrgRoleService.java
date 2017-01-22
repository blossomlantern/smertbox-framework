package com.smertbox.security.orgrole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.orgrole.mapper.SysOrgRoleMapper;
import com.smertbox.security.orgrole.model.SysOrgRole;

@Service
public class OrgRoleService {

	@Autowired
	SysOrgRoleMapper sysOrgRoleMapper;
	
	public SysOrgRole selectByPrimaryKey(String id){
		
		return sysOrgRoleMapper.selectByPrimaryKey(id);
	}

	public List<SysOrgRole> selectPage(SysOrgRole sysOrgRole) {
		
		return sysOrgRoleMapper.selectPage(sysOrgRole);
	}

	public int selectPageSize(SysOrgRole sysOrgRole) {
		
		return sysOrgRoleMapper.selectPageSize(sysOrgRole);
	}

	public void insert(SysOrgRole sysOrgRole) {
		
		sysOrgRoleMapper.insertSelective(sysOrgRole);
	}

	public void update(SysOrgRole sysOrgRole) {
		
		sysOrgRoleMapper.updateByPrimaryKeySelective(sysOrgRole);
	}

	public void delete(String id){
		
		sysOrgRoleMapper.deleteByPrimaryKey(id);
	}

	public void deleteByOrgId(String orgId) {
		
		sysOrgRoleMapper.deleteByOrgId(orgId);
	}
}
