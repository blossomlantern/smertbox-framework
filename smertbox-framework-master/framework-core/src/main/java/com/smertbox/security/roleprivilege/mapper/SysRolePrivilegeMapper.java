package com.smertbox.security.roleprivilege.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.roleprivilege.model.SysRolePrivilege;
import com.smertbox.security.roleprivilege.model.SysRolePrivilegeExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysRolePrivilegeMapper {
    int countByExample(SysRolePrivilegeExample example);

    int deleteByExample(SysRolePrivilegeExample example);

    int deleteByPrimaryKey(String rpId);

    int insert(SysRolePrivilege record);

    int insertSelective(SysRolePrivilege record);

    List<SysRolePrivilege> selectByExample(SysRolePrivilegeExample example);

    SysRolePrivilege selectByPrimaryKey(String rpId);

    int updateByExampleSelective(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);

    int updateByExample(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);

    int updateByPrimaryKeySelective(SysRolePrivilege record);

    int updateByPrimaryKey(SysRolePrivilege record);
    
    List<SysRolePrivilege> selectPage(SysRolePrivilege sysRolePrivilege);

	void deleteByRoleId(String roleId);

}