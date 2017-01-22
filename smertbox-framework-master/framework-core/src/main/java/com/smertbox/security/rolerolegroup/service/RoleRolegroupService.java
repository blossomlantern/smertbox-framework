package com.smertbox.security.rolerolegroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.rolerolegroup.mapper.SysRoleRolegroupMapper;
import com.smertbox.security.rolerolegroup.model.SysRoleRolegroup;

@Service
public class RoleRolegroupService {

	@Autowired
	SysRoleRolegroupMapper sysRoleRolegroupMapper;
	
	public SysRoleRolegroup selectByPrimaryKey(String id){
		
		return sysRoleRolegroupMapper.selectByPrimaryKey(id);
	}

	public void insert(SysRoleRolegroup sysRoleRolegroup) {
		
		sysRoleRolegroupMapper.insertSelective(sysRoleRolegroup);
	}

	public void update(SysRoleRolegroup sysRoleRolegroup) {
		
		sysRoleRolegroupMapper.updateByPrimaryKeySelective(sysRoleRolegroup);
	}

	public void deleteByRgId(String id){
		
		sysRoleRolegroupMapper.deleteByRgId(id);
	}
	
	public List<SysRoleRolegroup> selectAll(String rgId){
		
		return sysRoleRolegroupMapper.selectAll(rgId);
	}
}
