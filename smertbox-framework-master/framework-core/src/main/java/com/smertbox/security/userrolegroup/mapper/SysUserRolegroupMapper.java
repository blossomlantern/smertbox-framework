package com.smertbox.security.userrolegroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.userrolegroup.model.SysUserRolegroup;
import com.smertbox.security.userrolegroup.model.SysUserRolegroupExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysUserRolegroupMapper {
    int countByExample(SysUserRolegroupExample example);

    int deleteByExample(SysUserRolegroupExample example);

    int deleteByPrimaryKey(String urId);

    int insert(SysUserRolegroup record);

    int insertSelective(SysUserRolegroup record);

    List<SysUserRolegroup> selectByExample(SysUserRolegroupExample example);

    SysUserRolegroup selectByPrimaryKey(String urId);

    int updateByExampleSelective(@Param("record") SysUserRolegroup record, @Param("example") SysUserRolegroupExample example);

    int updateByExample(@Param("record") SysUserRolegroup record, @Param("example") SysUserRolegroupExample example);

    int updateByPrimaryKeySelective(SysUserRolegroup record);

    int updateByPrimaryKey(SysUserRolegroup record);
    
    List<SysUserRolegroup> selectPage(SysUserRolegroup sysUserRolegroup);
    
    int selectPageSize(SysUserRolegroup sysUserRolegroup);
    
    List<SysUserRolegroup> selectAll();

	void deleteByUserId(String userId);
}