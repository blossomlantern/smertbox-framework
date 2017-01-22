package com.smertbox.security.positionrole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.positionrole.model.SysPositionRole;
import com.smertbox.security.positionrole.model.SysPositionRoleExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysPositionRoleMapper {
    int countByExample(SysPositionRoleExample example);

    int deleteByExample(SysPositionRoleExample example);

    int deleteByPrimaryKey(String prId);

    int insert(SysPositionRole record);

    int insertSelective(SysPositionRole record);

    List<SysPositionRole> selectByExample(SysPositionRoleExample example);

    SysPositionRole selectByPrimaryKey(String prId);

    int updateByExampleSelective(@Param("record") SysPositionRole record, @Param("example") SysPositionRoleExample example);

    int updateByExample(@Param("record") SysPositionRole record, @Param("example") SysPositionRoleExample example);

    int updateByPrimaryKeySelective(SysPositionRole record);

    int updateByPrimaryKey(SysPositionRole record);
    
    List<SysPositionRole> selectPage(SysPositionRole sysPositionRole);
    
    int selectPageSize(SysPositionRole sysPositionRole);
    
    List<SysPositionRole> selectAll();

	void deleteByPositionId(String positionId);
}