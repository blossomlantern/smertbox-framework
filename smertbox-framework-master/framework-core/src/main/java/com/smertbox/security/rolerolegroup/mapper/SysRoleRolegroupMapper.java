package com.smertbox.security.rolerolegroup.mapper;

import com.smertbox.security.rolerolegroup.model.SysRoleRolegroup;
import com.smertbox.security.rolerolegroup.model.SysRoleRolegroupExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysRoleRolegroupMapper {
    int countByExample(SysRoleRolegroupExample example);

    int deleteByExample(SysRoleRolegroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRoleRolegroup record);

    int insertSelective(SysRoleRolegroup record);

    List<SysRoleRolegroup> selectByExample(SysRoleRolegroupExample example);

    SysRoleRolegroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRoleRolegroup record, @Param("example") SysRoleRolegroupExample example);

    int updateByExample(@Param("record") SysRoleRolegroup record, @Param("example") SysRoleRolegroupExample example);

    int updateByPrimaryKeySelective(SysRoleRolegroup record);

    int updateByPrimaryKey(SysRoleRolegroup record);

	void deleteByRgId(String rgId);

	List<SysRoleRolegroup> selectAll(String rgId);
}