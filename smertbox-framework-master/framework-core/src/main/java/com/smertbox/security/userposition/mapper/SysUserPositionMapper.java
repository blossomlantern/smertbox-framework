package com.smertbox.security.userposition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.userposition.model.SysUserPosition;
import com.smertbox.security.userposition.model.SysUserPositionExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysUserPositionMapper {
    int countByExample(SysUserPositionExample example);

    int deleteByExample(SysUserPositionExample example);

    int deleteByPrimaryKey(String upId);

    int insert(SysUserPosition record);

    int insertSelective(SysUserPosition record);

    List<SysUserPosition> selectByExample(SysUserPositionExample example);

    SysUserPosition selectByPrimaryKey(String upId);

    int updateByExampleSelective(@Param("record") SysUserPosition record, @Param("example") SysUserPositionExample example);

    int updateByExample(@Param("record") SysUserPosition record, @Param("example") SysUserPositionExample example);

    int updateByPrimaryKeySelective(SysUserPosition record);

    int updateByPrimaryKey(SysUserPosition record);
    
    List<SysUserPosition> selectPage(SysUserPosition sysUserPosition);
    
    int selectPageSize(SysUserPosition sysUserPosition);
    
    List<SysUserPosition> selectAll();

	void deleteByUserId(String userId);
}