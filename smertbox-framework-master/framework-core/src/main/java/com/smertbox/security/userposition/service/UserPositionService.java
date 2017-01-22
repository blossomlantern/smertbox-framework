package com.smertbox.security.userposition.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.userposition.mapper.SysUserPositionMapper;
import com.smertbox.security.userposition.model.SysUserPosition;

@Service
public class UserPositionService {

	@Autowired
	SysUserPositionMapper sysUserPositionMapper;
	
	public SysUserPosition selectByPrimaryKey(String id){
		
		return sysUserPositionMapper.selectByPrimaryKey(id);
	}

	public List<SysUserPosition> selectPage(SysUserPosition sysUserPosition) {
		
		return sysUserPositionMapper.selectPage(sysUserPosition);
	}

	public int selectPageSize(SysUserPosition sysUserPosition) {
		
		return sysUserPositionMapper.selectPageSize(sysUserPosition);
	}

	public void insert(SysUserPosition sysUserPosition) {
		
		sysUserPositionMapper.insertSelective(sysUserPosition);
	}

	public void update(SysUserPosition sysUserPosition) {
		
		sysUserPositionMapper.updateByPrimaryKeySelective(sysUserPosition);
	}

	public void delete(String id){
		
		sysUserPositionMapper.deleteByPrimaryKey(id);
	}

	public void deleteByUserId(String userId) {
		
		sysUserPositionMapper.deleteByUserId(userId);
	}
}
