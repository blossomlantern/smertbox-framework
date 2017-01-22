package com.smertbox.security.privilege.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.privilege.model.PrivilegeNode;
import com.smertbox.security.privilege.model.SysPrivilege;
import com.smertbox.security.privilege.model.SysPrivilegeExample;
import com.smertbox.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface SysPrivilegeMapper {
    int countByExample(SysPrivilegeExample example);

    int deleteByExample(SysPrivilegeExample example);

    int deleteByPrimaryKey(String pvgId);

    int insert(SysPrivilege record);

    int insertSelective(SysPrivilege record);

    List<SysPrivilege> selectByExample(SysPrivilegeExample example);

    SysPrivilege selectByPrimaryKey(String pvgId);

    int updateByExampleSelective(@Param("record") SysPrivilege record, @Param("example") SysPrivilegeExample example);

    int updateByExample(@Param("record") SysPrivilege record, @Param("example") SysPrivilegeExample example);

    int updateByPrimaryKeySelective(SysPrivilege record);

    int updateByPrimaryKey(SysPrivilege record);
    
    List<SysPrivilege> selectPageData(SysPrivilege sysPrivilege);

	int selectPageDataSize(SysPrivilege sysPrivilege);

	List<SysPrivilege> selectAll();

	List<PrivilegeNode> selectResourceTree();
}