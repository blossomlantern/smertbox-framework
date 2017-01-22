package com.smertbox.security.userorg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.userorg.model.SysUserOrg;
import com.smertbox.security.userorg.model.SysUserOrgExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysUserOrgMapper {
    int countByExample(SysUserOrgExample example);

    int deleteByExample(SysUserOrgExample example);

    int deleteByPrimaryKey(String uoId);

    int insert(SysUserOrg record);

    int insertSelective(SysUserOrg record);

    List<SysUserOrg> selectByExample(SysUserOrgExample example);

    SysUserOrg selectByPrimaryKey(String uoId);

    int updateByExampleSelective(@Param("record") SysUserOrg record, @Param("example") SysUserOrgExample example);

    int updateByExample(@Param("record") SysUserOrg record, @Param("example") SysUserOrgExample example);

    int updateByPrimaryKeySelective(SysUserOrg record);

    int updateByPrimaryKey(SysUserOrg record);
    
    List<SysUserOrg> selectPage(SysUserOrg sysUserOrg);
    
    int selectPageSize(SysUserOrg sysUserOrg);
    
    List<SysUserOrg> selectAll();

	void deleteByUserId(String userId);
}