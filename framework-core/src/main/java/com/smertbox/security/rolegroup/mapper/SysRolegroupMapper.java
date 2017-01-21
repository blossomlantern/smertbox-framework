package com.smertbox.security.rolegroup.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.rolegroup.model.SysRolegroup;
import com.smertbox.security.rolegroup.model.SysRolegroupExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysRolegroupMapper {
    int countByExample(SysRolegroupExample example);

    int deleteByExample(SysRolegroupExample example);

    int deleteByPrimaryKey(String rgId);

    int insert(SysRolegroup record);

    int insertSelective(SysRolegroup record);

    List<SysRolegroup> selectByExample(SysRolegroupExample example);

    SysRolegroup selectByPrimaryKey(String rgId);

    int updateByExampleSelective(@Param("record") SysRolegroup record, @Param("example") SysRolegroupExample example);

    int updateByExample(@Param("record") SysRolegroup record, @Param("example") SysRolegroupExample example);

    int updateByPrimaryKeySelective(SysRolegroup record);

    int updateByPrimaryKey(SysRolegroup record);
    
    List<SysRolegroup> selectPage(SysRolegroup sysRoleGroup);
    
    int selectPageSize(SysRolegroup sysRoleGroup);

	List<SysRolegroup> selectPageByOrgId(@Param("orgs") Set<String> orgs);
}