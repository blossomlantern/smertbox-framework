package com.smertbox.security.positionrole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.positionrole.mapper.SysPositionRoleMapper;
import com.smertbox.security.positionrole.model.SysPositionRole;

@Service
public class PositionRoleService {

	@Autowired
	SysPositionRoleMapper sysPositionRoleMapper;
	
	public SysPositionRole selectByPrimaryKey(String id){
		
		return sysPositionRoleMapper.selectByPrimaryKey(id);
	}

	public List<SysPositionRole> selectPage(SysPositionRole sysPositionRole) {
		
		return sysPositionRoleMapper.selectPage(sysPositionRole);
	}

	public int selectPageSize(SysPositionRole sysPositionRole) {
		
		return sysPositionRoleMapper.selectPageSize(sysPositionRole);
	}

	public void insert(SysPositionRole sysPositionRole) {
		
		sysPositionRoleMapper.insertSelective(sysPositionRole);
	}

	public void update(SysPositionRole sysPositionRole) {
		
		sysPositionRoleMapper.updateByPrimaryKeySelective(sysPositionRole);
	}

	public void delete(String id){
		
		sysPositionRoleMapper.deleteByPrimaryKey(id);
	}

	public void deleteByPositionId(String positionId) {
		
		sysPositionRoleMapper.deleteByPositionId(positionId);
	}
}
