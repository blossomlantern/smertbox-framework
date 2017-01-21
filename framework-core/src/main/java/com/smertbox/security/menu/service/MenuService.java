package com.smertbox.security.menu.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.smertbox.security.menu.mapper.SysMenuMapper;
import com.smertbox.security.menu.model.SysMenu;
import com.smertbox.util.tree.MenuTree;
import com.smertbox.util.tree.model.TreeNode;

@Service
public class MenuService {

	private Logger logger = Logger.getLogger(MenuService.class);
	
	@Autowired
	SysMenuMapper sysMenuMapper;
	
	/**
	 * @description 查询所有资源集合
	 * @return
	 */
	public List<SysMenu> selectAll(){
		return sysMenuMapper.selectAll();
	}
	
	/**
	 * @description 通过对象进行分页查询
	 * @param sysMenu
	 * @return
	 */
	public List<SysMenu> selectPage(SysMenu sysMenu){
		return sysMenuMapper.selectPage(sysMenu);
	}
	
	/**
	 * @description 通过对象查找分页数据总量
	 * @param sysMenu
	 * @return
	 */
	public int selectPageSize(SysMenu sysMenu){
		return sysMenuMapper.selectPageSize(sysMenu);
	}
	
	/**
	 * @description 获取资源树
	 * @return
	 */
	public List<TreeNode> selectResourceTree(){
		return sysMenuMapper.selectResourceTree();
	}
	
	/**
	 * @description 获取菜单树
	 * @return
	 */
	public List<TreeNode> selectMenuTree(){
		return sysMenuMapper.selectMenuTree();
	}
	
	/**
	 * @description 通过主键查找
	 * @param id
	 * @return
	 */
	public SysMenu selectByPrimaryKey(String id){
		return sysMenuMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * @description 插入操作
	 * @param sysMenu
	 */
	public void insert(SysMenu sysMenu){
		sysMenuMapper.insertSelective(sysMenu);
	}
	
	/**
	 * @description 更新操作
	 * @param sysMenu
	 */
	public void update(SysMenu sysMenu){
		sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
	}
	
	/**
	 * @description 删除操作
	 * @param id
	 */
	public void delete(String id){
		sysMenuMapper.deleteByPrimaryKey(id);
	}
	
	/*public List<MenuVO> queryMenuByUserAccountId(String accountId){
		//TODO
		return null;
	}*/
	
	/**
	 * 根据用户登录id获取菜单
	 * @param loginAccount
	 * @return
	 */
	public String selectMenuByUser(String loginAccount){
		if(StringUtils.isNotBlank(loginAccount)){
			List<SysMenu> menus = sysMenuMapper.selectMenuByUser(loginAccount);
			MenuTree mt = new MenuTree(menus);
			JSONArray product = mt.factory("0", 0);
			//logger.debug(product.toJSONString());
			return product != null ? product.toJSONString() : null;
		}
		return null;
	}
}
