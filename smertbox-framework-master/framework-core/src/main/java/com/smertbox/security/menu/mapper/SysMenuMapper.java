package com.smertbox.security.menu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smertbox.security.menu.model.SysMenu;
import com.smertbox.security.menu.model.SysMenuExample;
import com.smertbox.util.mapper.MyBatisRepository;
import com.smertbox.util.tree.model.TreeNode;

@MyBatisRepository
public interface SysMenuMapper {
    int countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

	List<SysMenu> selectAll();

	List<SysMenu> selectPage(SysMenu sysMenu);

	int selectPageSize(SysMenu sysMenu);

	List<TreeNode> selectMenuTree();
	
	List<TreeNode> selectResourceTree();
	
	List<SysMenu> selectMenuByUser(String loginAccount);
}