package com.smertbox.security.rolepvggroup.mapper;

import com.smertbox.security.rolepvggroup.model.SysRolePvggroup;
import com.smertbox.security.rolepvggroup.model.SysRolePvggroupExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysRolePvggroupMapper {
    int countByExample(SysRolePvggroupExample example);

    int deleteByExample(SysRolePvggroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRolePvggroup record);

    int insertSelective(SysRolePvggroup record);

    List<SysRolePvggroup> selectByExample(SysRolePvggroupExample example);

    SysRolePvggroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRolePvggroup record, @Param("example") SysRolePvggroupExample example);

    int updateByExample(@Param("record") SysRolePvggroup record, @Param("example") SysRolePvggroupExample example);

    int updateByPrimaryKeySelective(SysRolePvggroup record);

    int updateByPrimaryKey(SysRolePvggroup record);

	void deleteByRoleId(String roleId);

	List<SysRolePvggroup> selectAll(String roleId);
}