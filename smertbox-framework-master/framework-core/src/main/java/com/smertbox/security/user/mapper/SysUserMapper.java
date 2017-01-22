package com.smertbox.security.user.mapper;

import com.smertbox.security.user.model.SysUser;
import com.smertbox.security.user.model.SysUserExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	List<SysUser> selectByLoginAccount(String loginAccount);
	
	List<SysUser> selectPage(SysUser sysUser);
	
	int selectPageSize(SysUser sysUser);
	
	List<SysUser> selectAdminPage(SysUser sysUser);
	
	int selectAdminPageSize(SysUser sysUser);
	
	List<SysUser> selectManageUser();
}