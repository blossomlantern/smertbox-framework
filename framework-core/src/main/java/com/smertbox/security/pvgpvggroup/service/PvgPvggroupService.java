package com.smertbox.security.pvgpvggroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.pvgpvggroup.mapper.SysPvgPvggroupMapper;
import com.smertbox.security.pvgpvggroup.model.SysPvgPvggroup;

@Service
public class PvgPvggroupService {

	@Autowired
	SysPvgPvggroupMapper sysPvgPvggroupMapper;
	
	public SysPvgPvggroup selectByPrimaryKey(String id){
		
		return sysPvgPvggroupMapper.selectByPrimaryKey(id);
	}

	public void insert(SysPvgPvggroup sysPvgPvggroup) {
		
		sysPvgPvggroupMapper.insertSelective(sysPvgPvggroup);
	}

	public void update(SysPvgPvggroup sysPvgPvggroup) {
		
		sysPvgPvggroupMapper.updateByPrimaryKeySelective(sysPvgPvggroup);
	}

	public void deleteByPgId(String id){
		
		sysPvgPvggroupMapper.deleteByPgId(id);
	}
	
	public List<SysPvgPvggroup> selectAll(String pgId){
		
		return sysPvgPvggroupMapper.selectAll(pgId);
	}
}
