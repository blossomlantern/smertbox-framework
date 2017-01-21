package com.smertbox.security.pvggroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.pvggroup.mapper.SysPvggroupMapper;
import com.smertbox.security.pvggroup.model.SysPvggroup;

@Service
public class PvggroupService {

	@Autowired
	SysPvggroupMapper sysPrivilegeGroupMapper;
	
	public SysPvggroup selectByPrimaryKey(String id){
		
		return sysPrivilegeGroupMapper.selectByPrimaryKey(id);
	}

	public List<SysPvggroup> selectPage(SysPvggroup sysPvggroup) {
		
		return sysPrivilegeGroupMapper.selectPage(sysPvggroup);
	}

	public int selectPageSize(SysPvggroup sysPvggroup) {
		
		return sysPrivilegeGroupMapper.selectPageSize(sysPvggroup);
	}

	public void insert(SysPvggroup sysPvggroup) {
		
		sysPrivilegeGroupMapper.insertSelective(sysPvggroup);
	}

	public void update(SysPvggroup sysPvggroup) {
		
		sysPrivilegeGroupMapper.updateByPrimaryKeySelective(sysPvggroup);
	}

	public void delete(String id){
		
		sysPrivilegeGroupMapper.deleteByPrimaryKey(id);
	}
}
