package com.smertbox.system.param.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.system.param.mapper.CmParameterMapper;
import com.smertbox.system.param.model.CmParameter;

@Service
public class ParamService {

	@Autowired
	CmParameterMapper cmParameterMapper;
	
	/**
	 * @description 查询所有集合
	 * @return
	 */
	public List<CmParameter> selectAll(){
		return cmParameterMapper.selectAll();
	}
	
	/**
	 * @description 通过对象进行分页查询
	 * @param cmParameter
	 * @return
	 */
	public List<CmParameter> selectPage(CmParameter cmParameter){
		
		return cmParameterMapper.selectPage(cmParameter);
	}
	
	/**
	 * @description 通过对象查找分页数据总量
	 * @param cmParameter
	 * @return
	 */
	public int selectPageSize(CmParameter cmParameter){
		
		return cmParameterMapper.selectPageSize(cmParameter);
	}
	
	/**
	 * @description 获取树
	 * @return
	 */
	public List<CmParameter> selectParamTree(){
		return cmParameterMapper.selectParamTree();
	}
	
	/**
	 * @description 通过主键查找
	 * @param id
	 * @return
	 */
	public CmParameter selectByPrimaryKey(String id){
		return cmParameterMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * @description 插入操作
	 * @param cmParameter
	 */
	public void insert(CmParameter cmParameter){
		cmParameterMapper.insertSelective(cmParameter);
	}
	
	/**
	 * @description 更新操作
	 * @param cmParameter
	 */
	public void update(CmParameter cmParameter){
		cmParameterMapper.updateByPrimaryKeySelective(cmParameter);
	}
	
	/**
	 * @description 删除操作
	 * @param id
	 */
	public void delete(String id){
		cmParameterMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 级联删除
	 * @param id
	 */
	public void deleteCascade(String parId) {
		cmParameterMapper.deleteCascade(parId);
	}
	
}
