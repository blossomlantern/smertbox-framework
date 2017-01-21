package com.smertbox.security.log.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.security.log.mapper.SysLogMapper;
import com.smertbox.security.log.model.SysLog;

@Service
public class LogService {

	private Logger logger = Logger.getLogger(LogService.class);
	
	@Autowired
	SysLogMapper sysLogMapper;
	
	/**
	 * @description 通过对象进行分页查询
	 * @param sysLog
	 * @return
	 */
	public List<SysLog> selectPage(SysLog sysLog){
		return sysLogMapper.selectPage(sysLog);
	}
	
	/**
	 * @description 通过对象查找分页数据总量
	 * @param sysLog
	 * @return
	 */
	public int selectPageSize(SysLog sysLog){
		return sysLogMapper.selectPageSize(sysLog);
	}
	
	
	/**
	 * @description 通过主键查找
	 * @param id
	 * @return
	 */
	public SysLog selectByPrimaryKey(String id){
		return sysLogMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * @description 插入操作
	 * @param sysLog
	 */
	public void insert(SysLog sysLog){
		sysLogMapper.insertSelective(sysLog);
	}
	
	/**
	 * @description 更新操作
	 * @param sysLog
	 */
	public void update(SysLog sysLog){
		sysLogMapper.updateByPrimaryKeySelective(sysLog);
	}
	
	/**
	 * @description 删除操作
	 * @param id
	 */
	public void delete(String id){
		sysLogMapper.deleteByPrimaryKey(id);
	}

	public void clean() {
		sysLogMapper.clean();
	}
}
