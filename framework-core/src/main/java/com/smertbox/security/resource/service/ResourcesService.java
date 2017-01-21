package com.smertbox.security.resource.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.core.filter.CustomFilterInvocationSecurityMetadataSource;
import com.smertbox.security.resource.mapper.SysResourcesMapper;
import com.smertbox.security.resource.model.ResourceNode;
import com.smertbox.security.resource.model.SysResources;

@Service
public class ResourcesService {

	@Autowired
	SysResourcesMapper sysResourcesMapper;
	@Autowired
	CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
	
	/**
	 * @description 查询所有资源集合
	 * @return
	 */
	public List<SysResources> selectAll(){
		return sysResourcesMapper.selectAll();
	}
	
	/**
	 * @description 通过资源对象进行分页查询
	 * @param resources
	 * @return
	 */
	public List<SysResources> selectPageData(SysResources resources){
		return sysResourcesMapper.selectPageData(resources);
	}
	
	/**
	 * @description 通过资源对象查找分页数据总量
	 * @param resources
	 * @return
	 */
	public int selectPageDataSize(SysResources resources){
		return sysResourcesMapper.selectPageDataSize(resources);
	}
	
	/**
	 * @description 获取资源树
	 * @return
	 */
	public List<ResourceNode> selectResourceTree(){
		return sysResourcesMapper.selectResourceTree();
	}
	
	/**
	 * @description 通过主键查找
	 * @param id
	 * @return
	 */
	public SysResources selectByPrimaryKey(String id){
		return sysResourcesMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * @description 插入操作
	 * @param resources
	 */
	public void insert(SysResources resources){
		sysResourcesMapper.insertSelective(resources);
		reloadResource();
	}
	
	/**
	 * @description 更新操作
	 * @param resources
	 */
	public void update(SysResources resources){
		sysResourcesMapper.updateByPrimaryKeySelective(resources);
		reloadResource();
	}
	
	/**
	 * @description 删除操作
	 * @param id
	 */
	public void delete(String id){
		sysResourcesMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * @description 重新加载全部资源 以供系统使用
	 */
	public void reloadResource(){
		customFilterInvocationSecurityMetadataSource.reloadResource();
	}
	
	public List<SysResources> selectByUserRole(String loginAccount){
		if(StringUtils.isNotBlank(loginAccount)){
			return sysResourcesMapper.selectByUserRole(loginAccount);
		}
		return null;
	}
	
	public List<SysResources> selectByUserPosition(String loginAccount){
		if(StringUtils.isNotBlank(loginAccount)){
			return sysResourcesMapper.selectByUserPosition(loginAccount);
		}
		return null;
	}
	
}
