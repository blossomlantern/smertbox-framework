package com.smertbox.security.userorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.userorg.mapper.SysUserOrgMapper;
import com.smertbox.security.userorg.model.SysUserOrg;

@Service
public class UserOrgService {

	@Autowired
	SysUserOrgMapper sysUserOrgMapper;
	
	public SysUserOrg selectByPrimaryKey(String id){
		
		return sysUserOrgMapper.selectByPrimaryKey(id);
	}

	public List<SysUserOrg> selectPage(SysUserOrg sysUserOrg) {
		
		return sysUserOrgMapper.selectPage(sysUserOrg);
	}

	public int selectPageSize(SysUserOrg sysUserOrg) {
		
		return sysUserOrgMapper.selectPageSize(sysUserOrg);
	}

	public void insert(SysUserOrg sysUserOrg) {
		
		sysUserOrgMapper.insertSelective(sysUserOrg);
	}

	public void update(SysUserOrg sysUserOrg) {
		
		sysUserOrgMapper.updateByPrimaryKeySelective(sysUserOrg);
	}

	public void delete(String id){
		
		sysUserOrgMapper.deleteByPrimaryKey(id);
	}

	public void deleteByUserId(String userId) {
		
		sysUserOrgMapper.deleteByUserId(userId);
	}
}
