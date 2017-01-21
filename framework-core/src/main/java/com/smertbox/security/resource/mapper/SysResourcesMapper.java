package com.smertbox.security.resource.mapper;

import com.smertbox.security.resource.model.ResourceNode;
import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.resource.model.SysResourcesExample;
import com.smertbox.security.user.model.SysUser;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysResourcesMapper {
    int countByExample(SysResourcesExample example);

    int deleteByExample(SysResourcesExample example);

    int deleteByPrimaryKey(String resId);

    int insert(SysResources record);

    int insertSelective(SysResources record);

    List<SysResources> selectByExample(SysResourcesExample example);

    SysResources selectByPrimaryKey(String resId);

    int updateByExampleSelective(@Param("record") SysResources record, @Param("example") SysResourcesExample example);

    int updateByExample(@Param("record") SysResources record, @Param("example") SysResourcesExample example);

    int updateByPrimaryKeySelective(SysResources record);

    int updateByPrimaryKey(SysResources record);

	List<SysResources> selectAll();

	List<SysResources> selectByUser(SysUser user);
	
	List<SysResources> selectPageData(SysResources resources);

	int selectPageDataSize(SysResources resources);
	
	List<ResourceNode> selectResourceTree();
	
	List<SysResources> selectByUserRole(String loginAccount);
	
	List<SysResources> selectByUserPosition(String loginAccount);
}