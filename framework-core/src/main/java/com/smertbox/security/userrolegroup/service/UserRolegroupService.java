package com.smertbox.security.userrolegroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.userrolegroup.mapper.SysUserRolegroupMapper;
import com.smertbox.security.userrolegroup.model.SysUserRolegroup;

@Service
public class UserRolegroupService {

	@Autowired
	SysUserRolegroupMapper sysUserRolegroupMapper;
	
	public SysUserRolegroup selectByPrimaryKey(String id){
		
		return sysUserRolegroupMapper.selectByPrimaryKey(id);
	}

	public List<SysUserRolegroup> selectPage(SysUserRolegroup sysUserRolegroup) {
		
		return sysUserRolegroupMapper.selectPage(sysUserRolegroup);
	}

	public int selectPageSize(SysUserRolegroup sysUserRolegroup) {
		
		return sysUserRolegroupMapper.selectPageSize(sysUserRolegroup);
	}

	public void insert(SysUserRolegroup sysUserRolegroup) {
		
		sysUserRolegroupMapper.insertSelective(sysUserRolegroup);
	}

	public void update(SysUserRolegroup sysUserRolegroup) {
		
		sysUserRolegroupMapper.updateByPrimaryKeySelective(sysUserRolegroup);
	}

	public void delete(String id){
		
		sysUserRolegroupMapper.deleteByPrimaryKey(id);
	}

	public void deleteByUserId(String userId) {
		
		sysUserRolegroupMapper.deleteByUserId(userId);
	}
}
