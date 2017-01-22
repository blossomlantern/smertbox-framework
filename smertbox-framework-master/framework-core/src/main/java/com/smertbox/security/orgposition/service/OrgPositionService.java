package com.smertbox.security.orgposition.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.orgposition.mapper.SysOrgPositionMapper;
import com.smertbox.security.orgposition.model.SysOrgPosition;

@Service
public class OrgPositionService {

	@Autowired
	SysOrgPositionMapper sysOrgPositionMapper;
	
	public SysOrgPosition selectByPrimaryKey(String id){
		
		return sysOrgPositionMapper.selectByPrimaryKey(id);
	}

	public List<SysOrgPosition> selectPage(SysOrgPosition sysOrgPosition) {
		
		return sysOrgPositionMapper.selectPage(sysOrgPosition);
	}

	public int selectPageSize(SysOrgPosition sysOrgPosition) {
		
		return sysOrgPositionMapper.selectPageSize(sysOrgPosition);
	}

	public void insert(SysOrgPosition sysOrgPosition) {
		
		sysOrgPositionMapper.insertSelective(sysOrgPosition);
	}

	public void update(SysOrgPosition sysOrgPosition) {
		
		sysOrgPositionMapper.updateByPrimaryKeySelective(sysOrgPosition);
	}

	public void delete(String id){
		
		sysOrgPositionMapper.deleteByPrimaryKey(id);
	}

	public void deleteByOrgId(String orgId) {
		
		sysOrgPositionMapper.deleteByOrgId(orgId);
	}
}
