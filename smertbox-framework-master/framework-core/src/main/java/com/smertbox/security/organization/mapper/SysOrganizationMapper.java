package com.smertbox.security.organization.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.organization.model.SysOrganization;
import com.smertbox.security.organization.model.SysOrganizationExample;
import com.smertbox.util.mapper.MyBatisRepository;
import com.smertbox.util.tree.model.TreeNode;

@MyBatisRepository
public interface SysOrganizationMapper {
    int countByExample(SysOrganizationExample example);

    int deleteByExample(SysOrganizationExample example);

    int deleteByPrimaryKey(String orgId);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    List<SysOrganization> selectByExample(SysOrganizationExample example);

    SysOrganization selectByPrimaryKey(String orgId);

    int updateByExampleSelective(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    int updateByExample(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);
    
    int selectPageSize(SysOrganization sysOrganization);
    
    List<SysOrganization> selectPage(SysOrganization sysOrganization);

	List<SysOrganization> selectAll();

	List<TreeNode> selectOrganizationTree(String loginAccount);

	List<TreeNode> selectAdminOrganizationTree();
}