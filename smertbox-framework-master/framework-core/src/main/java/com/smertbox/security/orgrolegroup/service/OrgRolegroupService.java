package com.smertbox.security.orgrolegroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.orgrolegroup.mapper.SysOrgRolegroupMapper;
import com.smertbox.security.orgrolegroup.model.SysOrgRolegroup;

@Service
public class OrgRolegroupService {

	@Autowired
	SysOrgRolegroupMapper sysOrgRolegroupMapper;
	
	public SysOrgRolegroup selectByPrimaryKey(String id){
		
		return sysOrgRolegroupMapper.selectByPrimaryKey(id);
	}

	public List<SysOrgRolegroup> selectPage(SysOrgRolegroup sysOrgRolegroup) {
		
		return sysOrgRolegroupMapper.selectPage(sysOrgRolegroup);
	}

	public int selectPageSize(SysOrgRolegroup sysOrgRolegroup) {
		
		return sysOrgRolegroupMapper.selectPageSize(sysOrgRolegroup);
	}

	public void insert(SysOrgRolegroup sysOrgRolegroup) {
		
		sysOrgRolegroupMapper.insertSelective(sysOrgRolegroup);
	}

	public void update(SysOrgRolegroup sysOrgRolegroup) {
		
		sysOrgRolegroupMapper.updateByPrimaryKeySelective(sysOrgRolegroup);
	}

	public void delete(String id){
		
		sysOrgRolegroupMapper.deleteByPrimaryKey(id);
	}

	public void deleteByOrgId(String orgId) {
		
		sysOrgRolegroupMapper.deleteByOrgId(orgId);
	}
}
