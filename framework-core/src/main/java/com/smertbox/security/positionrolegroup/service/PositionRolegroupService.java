package com.smertbox.security.positionrolegroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.positionrolegroup.mapper.SysPositionRolegroupMapper;
import com.smertbox.security.positionrolegroup.model.SysPositionRolegroup;

@Service
public class PositionRolegroupService {

	@Autowired
	SysPositionRolegroupMapper sysPositionRolegroupMapper;
	
	public SysPositionRolegroup selectByPrimaryKey(String id){
		
		return sysPositionRolegroupMapper.selectByPrimaryKey(id);
	}

	public List<SysPositionRolegroup> selectPage(SysPositionRolegroup sysPositionRolegroup) {
		
		return sysPositionRolegroupMapper.selectPage(sysPositionRolegroup);
	}

	public int selectPageSize(SysPositionRolegroup sysPositionRolegroup) {
		
		return sysPositionRolegroupMapper.selectPageSize(sysPositionRolegroup);
	}

	public void insert(SysPositionRolegroup sysPositionRolegroup) {
		
		sysPositionRolegroupMapper.insertSelective(sysPositionRolegroup);
	}

	public void update(SysPositionRolegroup sysPositionRolegroup) {
		
		sysPositionRolegroupMapper.updateByPrimaryKeySelective(sysPositionRolegroup);
	}

	public void delete(String id){
		
		sysPositionRolegroupMapper.deleteByPrimaryKey(id);
	}

	public void deleteByPositionId(String positionId) {
		
		sysPositionRolegroupMapper.deleteByPositionId(positionId);
	}
}
