package com.smertbox.security.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.organization.mapper.SysOrganizationMapper;
import com.smertbox.security.organization.model.SysOrganization;
import com.smertbox.util.tree.model.TreeNode;

@Service
public class OrganizationService {

	@Autowired
	SysOrganizationMapper sysOrganizationMapper;
	
	/**
	 * @description 查询所有
	 * @return
	 */
	public List<SysOrganization> selectAll(){
		return sysOrganizationMapper.selectAll();
	}
	
	/**
	 * @description 通过职位对象进行分页查询
	 * @param sysOrganization
	 * @return
	 */
	public List<SysOrganization> selectPage(SysOrganization sysOrganization){
		return sysOrganizationMapper.selectPage(sysOrganization);
	}
	
	/**
	 * @description 通过对象查找分页数据总量
	 * @param sysOrganization
	 * @return
	 */
	public int selectPageSize(SysOrganization sysOrganization){
		return sysOrganizationMapper.selectPageSize(sysOrganization);
	}
	
	/**
	 * @description 通过主键查找
	 * @param id
	 * @return
	 */
	public SysOrganization selectByPrimaryKey(String id){
		return sysOrganizationMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * @description 插入操作
	 * @param sysOrganization
	 */
	public void insert(SysOrganization sysOrganization){
		sysOrganizationMapper.insertSelective(sysOrganization);
	}
	
	/**
	 * @description 更新操作
	 * @param sysOrganization
	 */
	public void update(SysOrganization sysOrganization){
		sysOrganizationMapper.updateByPrimaryKeySelective(sysOrganization);
	}
	
	/**
	 * @description 删除操作
	 * @param id
	 */
	public void delete(String id){
		sysOrganizationMapper.deleteByPrimaryKey(id);
	}

	public List<TreeNode> selectOrganizationTree(String loginAccount) {
		return sysOrganizationMapper.selectOrganizationTree(loginAccount);
	}
	
	public List<TreeNode> selectAdminOrganizationTree() {
		return sysOrganizationMapper.selectAdminOrganizationTree();
	}
}
