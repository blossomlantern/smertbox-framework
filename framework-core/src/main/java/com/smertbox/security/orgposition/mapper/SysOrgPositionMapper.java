package com.smertbox.security.orgposition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.orgposition.model.SysOrgPosition;
import com.smertbox.security.orgposition.model.SysOrgPositionExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysOrgPositionMapper {
    int countByExample(SysOrgPositionExample example);

    int deleteByExample(SysOrgPositionExample example);

    int deleteByPrimaryKey(String opId);

    int insert(SysOrgPosition record);

    int insertSelective(SysOrgPosition record);

    List<SysOrgPosition> selectByExample(SysOrgPositionExample example);

    SysOrgPosition selectByPrimaryKey(String opId);

    int updateByExampleSelective(@Param("record") SysOrgPosition record, @Param("example") SysOrgPositionExample example);

    int updateByExample(@Param("record") SysOrgPosition record, @Param("example") SysOrgPositionExample example);

    int updateByPrimaryKeySelective(SysOrgPosition record);

    int updateByPrimaryKey(SysOrgPosition record);
    
    List<SysOrgPosition> selectPage(SysOrgPosition sysOrgPosition);
    
    int selectPageSize(SysOrgPosition sysOrgPosition);
    
    List<SysOrgPosition> selectAll();

	void deleteByOrgId(String orgId);
}