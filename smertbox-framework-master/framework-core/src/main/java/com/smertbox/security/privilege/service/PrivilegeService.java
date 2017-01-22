package com.smertbox.security.privilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.privilege.mapper.SysPrivilegeMapper;
import com.smertbox.security.privilege.model.PrivilegeNode;
import com.smertbox.security.privilege.model.SysPrivilege;

@Service
public class PrivilegeService {

	@Autowired
	SysPrivilegeMapper sysPrivilegeMapper;
	
	/**
	 * @description 查询所有资源集合
	 * @return
	 */
	public List<SysPrivilege> selectAll(){
		return sysPrivilegeMapper.selectAll();
	}
	
	/**
	 * @description 通过资源对象进行分页查询
	 * @param resources
	 * @return
	 */
	public List<SysPrivilege> selectPageData(SysPrivilege resources){
		return sysPrivilegeMapper.selectPageData(resources);
	}
	
	/**
	 * @description 通过资源对象查找分页数据总量
	 * @param resources
	 * @return
	 */
	public int selectPageDataSize(SysPrivilege resources){
		return sysPrivilegeMapper.selectPageDataSize(resources);
	}
	
	/**
	 * @description 获取资源树
	 * @return
	 */
	public List<PrivilegeNode> selectResourceTree(){
		return sysPrivilegeMapper.selectResourceTree();
	}
	
	/**
	 * @description 通过主键查找
	 * @param id
	 * @return
	 */
	public SysPrivilege selectByPrimaryKey(String id){
		return sysPrivilegeMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * @description 插入操作
	 * @param resources
	 */
	public void insert(SysPrivilege resources){
		sysPrivilegeMapper.insertSelective(resources);
	}
	
	/**
	 * @description 更新操作
	 * @param resources
	 */
	public void update(SysPrivilege resources){
		sysPrivilegeMapper.updateByPrimaryKeySelective(resources);
	}
	
	/**
	 * @description 删除操作
	 * @param id
	 */
	public void delete(String id){
		sysPrivilegeMapper.deleteByPrimaryKey(id);
	}
}
