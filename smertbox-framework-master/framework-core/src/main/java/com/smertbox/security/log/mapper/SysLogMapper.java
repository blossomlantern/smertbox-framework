package com.smertbox.security.log.mapper;

import com.smertbox.security.log.model.SysLog;
import com.smertbox.security.log.model.SysLogExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysLogMapper {
    int countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

	List<SysLog> selectPage(SysLog sysLog);

	int selectPageSize(SysLog sysLog);

	int clean();
}