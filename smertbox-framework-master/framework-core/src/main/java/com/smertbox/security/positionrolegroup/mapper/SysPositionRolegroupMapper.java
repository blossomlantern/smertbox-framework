package com.smertbox.security.positionrolegroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.positionrolegroup.model.SysPositionRolegroup;
import com.smertbox.security.positionrolegroup.model.SysPositionRolegroupExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysPositionRolegroupMapper {
    int countByExample(SysPositionRolegroupExample example);

    int deleteByExample(SysPositionRolegroupExample example);

    int deleteByPrimaryKey(String prId);

    int insert(SysPositionRolegroup record);

    int insertSelective(SysPositionRolegroup record);

    List<SysPositionRolegroup> selectByExample(SysPositionRolegroupExample example);

    SysPositionRolegroup selectByPrimaryKey(String prId);

    int updateByExampleSelective(@Param("record") SysPositionRolegroup record, @Param("example") SysPositionRolegroupExample example);

    int updateByExample(@Param("record") SysPositionRolegroup record, @Param("example") SysPositionRolegroupExample example);

    int updateByPrimaryKeySelective(SysPositionRolegroup record);

    int updateByPrimaryKey(SysPositionRolegroup record);
    
    List<SysPositionRolegroup> selectPage(SysPositionRolegroup sysPositionRolegroup);
    
    int selectPageSize(SysPositionRolegroup sysPositionRolegroup);
    
    List<SysPositionRolegroup> selectAll();

	void deleteByPositionId(String positionId);
}