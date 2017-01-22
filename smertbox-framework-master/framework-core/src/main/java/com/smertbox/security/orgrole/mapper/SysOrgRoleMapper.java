package com.smertbox.security.orgrole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.orgrole.model.SysOrgRole;
import com.smertbox.security.orgrole.model.SysOrgRoleExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysOrgRoleMapper {
    int countByExample(SysOrgRoleExample example);

    int deleteByExample(SysOrgRoleExample example);

    int deleteByPrimaryKey(String orId);

    int insert(SysOrgRole record);

    int insertSelective(SysOrgRole record);

    List<SysOrgRole> selectByExample(SysOrgRoleExample example);

    SysOrgRole selectByPrimaryKey(String orId);

    int updateByExampleSelective(@Param("record") SysOrgRole record, @Param("example") SysOrgRoleExample example);

    int updateByExample(@Param("record") SysOrgRole record, @Param("example") SysOrgRoleExample example);

    int updateByPrimaryKeySelective(SysOrgRole record);

    int updateByPrimaryKey(SysOrgRole record);
    
    List<SysOrgRole> selectPage(SysOrgRole sysOrgRole);
    
    int selectPageSize(SysOrgRole sysOrgRole);
    
    List<SysOrgRole> selectAll();

	void deleteByOrgId(String orgId);
}