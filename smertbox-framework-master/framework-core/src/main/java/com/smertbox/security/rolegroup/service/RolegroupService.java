package com.smertbox.security.rolegroup.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.rolegroup.mapper.SysRolegroupMapper;
import com.smertbox.security.rolegroup.model.SysRolegroup;

@Service
public class RolegroupService {

	@Autowired
	SysRolegroupMapper sysRoleGroupMapper;
	
	public SysRolegroup selectByPrimaryKey(String id){
		
		return sysRoleGroupMapper.selectByPrimaryKey(id);
	}

	public List<SysRolegroup> selectPage(SysRolegroup sysRolegroup) {
		
		return sysRoleGroupMapper.selectPage(sysRolegroup);
	}

	public int selectPageSize(SysRolegroup sysRolegroup) {
		
		return sysRoleGroupMapper.selectPageSize(sysRolegroup);
	}

	public void insert(SysRolegroup sysRolegroup) {
		
		sysRoleGroupMapper.insertSelective(sysRolegroup);
	}

	public void update(SysRolegroup sysRolegroup) {
		
		sysRoleGroupMapper.updateByPrimaryKeySelective(sysRolegroup);
	}

	public void delete(String rgId){
		
		sysRoleGroupMapper.deleteByPrimaryKey(rgId);
	}

	public List<SysRolegroup> selectPageByOrgId(Set<String> orgs) {
		if(orgs == null || orgs.size() == 0){
			return null;
		}
		return sysRoleGroupMapper.selectPageByOrgId(orgs);
	}
}
