package com.smertbox.security.position.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.position.mapper.SysPositionMapper;
import com.smertbox.security.position.model.SysPosition;

@Service
public class PositionService {

	@Autowired
	SysPositionMapper sysPositionMapper;
	
	/**
	 * @description 查询所有职位集合
	 * @return
	 */
	public List<SysPosition> selectAll(){
		return sysPositionMapper.selectAll();
	}
	
	/**
	 * @description 通过职位对象进行分页查询
	 * @param sysPosition
	 * @return
	 */
	public List<SysPosition> selectPage(SysPosition sysPosition){
		return sysPositionMapper.selectPage(sysPosition);
	}
	
	/**
	 * @description 通过职位对象查找分页数据总量
	 * @param sysPosition
	 * @return
	 */
	public int selectPageSize(SysPosition sysPosition){
		return sysPositionMapper.selectPageSize(sysPosition);
	}
	
	/**
	 * @description 通过主键查找
	 * @param id
	 * @return
	 */
	public SysPosition selectByPrimaryKey(String id){
		return sysPositionMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * @description 插入操作
	 * @param sysPosition
	 */
	public void insert(SysPosition sysPosition){
		sysPositionMapper.insertSelective(sysPosition);
	}
	
	/**
	 * @description 更新操作
	 * @param sysPosition
	 */
	public void update(SysPosition sysPosition){
		sysPositionMapper.updateByPrimaryKeySelective(sysPosition);
	}
	
	/**
	 * @description 删除操作
	 * @param id
	 */
	public void delete(String id){
		sysPositionMapper.deleteByPrimaryKey(id);
	}
	
	public List<SysPosition> selectAllHaveParam(){
		return sysPositionMapper.selectAllHaveParam();
	}
	
	public List<String> selectAllPositionType(){
		return sysPositionMapper.selectAllPositionType();
	}

	public List<SysPosition> selectPageByUserId(String userId) {
		
		return sysPositionMapper.selectPageByUserId(userId);
	}
	
	public List<SysPosition> selectByLoginAccount(String loginAccount){
		return sysPositionMapper.selectByLoginAccount(loginAccount);
	}
}
