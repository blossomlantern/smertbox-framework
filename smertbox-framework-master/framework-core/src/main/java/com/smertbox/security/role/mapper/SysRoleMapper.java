package com.smertbox.security.role.mapper;

import com.smertbox.security.role.model.SysRole;
import com.smertbox.security.role.model.SysRoleExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectAll(SysRole sysRole);
    
	List<SysRole> selectPageData(SysRole sysRole);

	int selectPageDataSize(SysRole sysRole);

	List<SysRole> selectPageByOrgId(@Param("orgs") Set<String> orgs);
}