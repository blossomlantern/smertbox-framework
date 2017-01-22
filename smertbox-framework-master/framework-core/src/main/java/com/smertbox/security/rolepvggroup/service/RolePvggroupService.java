package com.smertbox.security.rolepvggroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.rolepvggroup.mapper.SysRolePvggroupMapper;
import com.smertbox.security.rolepvggroup.model.SysRolePvggroup;

@Service
public class RolePvggroupService {

	@Autowired
	SysRolePvggroupMapper sysRolePvggroupMapper;
	
	public SysRolePvggroup selectByPrimaryKey(String id){
		
		return sysRolePvggroupMapper.selectByPrimaryKey(id);
	}

	public void insert(SysRolePvggroup sysRolePvggroup) {
		
		sysRolePvggroupMapper.insertSelective(sysRolePvggroup);
	}

	public void update(SysRolePvggroup sysRolePvggroup) {
		
		sysRolePvggroupMapper.updateByPrimaryKeySelective(sysRolePvggroup);
	}

	public void deleteByPgId(String id){
		
		sysRolePvggroupMapper.deleteByRoleId(id);
	}
	
	public List<SysRolePvggroup> selectAll(String roleId){
		
		return sysRolePvggroupMapper.selectAll(roleId);
	}
}
