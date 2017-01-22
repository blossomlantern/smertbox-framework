package com.smertbox.security.resourceprivilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.resourceprivilege.mapper.SysResPvgMapper;
import com.smertbox.security.resourceprivilege.model.SysResPvg;

@Service
public class ResourcePrivilegeService {

	@Autowired
	SysResPvgMapper sysResPvgMapper;
	
	/**
	 * @description 插入操作
	 * @param resources
	 */
	public void insert(SysResPvg sysResPvg){
		sysResPvgMapper.insertSelective(sysResPvg);
	}
	
	public SysResPvg selectByPrimaryKey(String id){
		return sysResPvgMapper.selectByPrimaryKey(id);
	}
	
	public List<SysResPvg> selectPage(SysResPvg sysResPvg){
		return sysResPvgMapper.selectPage(sysResPvg);
	}

	public void update(SysResPvg srp) {
		sysResPvgMapper.updateByPrimaryKeySelective(srp);
	}
}
