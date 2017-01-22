package com.smertbox.security.userrole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.userrole.model.SysUserRole;
import com.smertbox.security.userrole.model.SysUserRoleExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysUserRoleMapper {
    int countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(String urId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    SysUserRole selectByPrimaryKey(String urId);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
    
    List<SysUserRole> selectPage(SysUserRole sysUserRole);
    
    int selectPageSize(SysUserRole sysUserRole);
    
    List<SysUserRole> selectAll();

	void deleteByUserId(String userId);
}