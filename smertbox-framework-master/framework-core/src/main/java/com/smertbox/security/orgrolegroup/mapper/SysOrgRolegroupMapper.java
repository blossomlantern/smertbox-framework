package com.smertbox.security.orgrolegroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.orgrolegroup.model.SysOrgRolegroup;
import com.smertbox.security.orgrolegroup.model.SysOrgRolegroupExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysOrgRolegroupMapper {
    int countByExample(SysOrgRolegroupExample example);

    int deleteByExample(SysOrgRolegroupExample example);

    int deleteByPrimaryKey(String orId);

    int insert(SysOrgRolegroup record);

    int insertSelective(SysOrgRolegroup record);

    List<SysOrgRolegroup> selectByExample(SysOrgRolegroupExample example);

    SysOrgRolegroup selectByPrimaryKey(String orId);

    int updateByExampleSelective(@Param("record") SysOrgRolegroup record, @Param("example") SysOrgRolegroupExample example);

    int updateByExample(@Param("record") SysOrgRolegroup record, @Param("example") SysOrgRolegroupExample example);

    int updateByPrimaryKeySelective(SysOrgRolegroup record);

    int updateByPrimaryKey(SysOrgRolegroup record);
    
    List<SysOrgRolegroup> selectPage(SysOrgRolegroup sysOrgRolegroup);
    
    int selectPageSize(SysOrgRolegroup sysOrgRolegroup);
    
    List<SysOrgRolegroup> selectAll();

	void deleteByOrgId(String orgId);
}