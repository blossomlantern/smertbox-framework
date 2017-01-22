package com.smertbox.security.user.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.resource.mapper.SysResourcesMapper;
import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.user.mapper.SysUserMapper;
import com.smertbox.security.user.model.SysUser;

@Service
public class UserService {

	private Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	SysResourcesMapper sysResourcesMapper;
	
	/**
	 * @description 通过用户登录账号查找用户
	 * @param loginAccount
	 * @return
	 */
	public SysUser selectByLoginAccount(String loginAccount){
		List<SysUser> list = sysUserMapper.selectByLoginAccount(loginAccount);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	public List<SysUser> selectListByLoginAccount(String loginAccount){
		return sysUserMapper.selectByLoginAccount(loginAccount);
	}
	
	public SysUser selectByPrimaryKey(String userId){
		return sysUserMapper.selectByPrimaryKey(userId);
	}
	
	public void insert(SysUser user){
		sysUserMapper.insertSelective(user);
	}
	
	public void update(SysUser user){
		sysUserMapper.updateByPrimaryKeySelective(user);
	}
	
	public void delete(String userId){
		sysUserMapper.deleteByPrimaryKey(userId);
	}
	
	/**
	 * @description 通过用户查询用户所拥有的资源
	 * @param user
	 * @return
	 */
	public List<SysResources> selectByUser(SysUser user){
		return sysResourcesMapper.selectByUser(user);
	}
	
	public List<SysUser> selectPage(SysUser sysUser){
		return sysUserMapper.selectPage(sysUser);
	}
	
	public int selectPageSize(SysUser sysUser){
		return sysUserMapper.selectPageSize(sysUser);
	}
	
	public List<SysUser> selectAdminPage(SysUser sysUser){
		return sysUserMapper.selectAdminPage(sysUser);
	}
	
	public int selectAdminPageSize(SysUser sysUser){
		return sysUserMapper.selectAdminPageSize(sysUser);
	}
	
	public boolean ismanage(String loginAccount){
		List<SysUser> list = sysUserMapper.selectManageUser();
		if(StringUtils.isNotBlank(loginAccount) && list != null && list.size() > 0){
			for (int i = 0; i <list.size(); i++) {
				if(loginAccount.equals(list.get(i).getLoginAccount())){
					return true;
				}
			}
		}
		return false;
	}
}
