package com.smertbox.util.tree;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smertbox.security.menu.model.SysMenu;

/**
 * 构造菜单树 并对数据进行简单加工 以便在前台进行显示。
 * @author ladeng
 */
public class MenuTree {

	private static Logger logger = Logger.getLogger(MenuTree.class);
	
	private List<SysMenu> menus;
	
	private int active = 0;
	
	private int rootActive = 0;
	
	public MenuTree(List<SysMenu> menus){
		this.menus = menus;
	}
	
	/**
	 * 通过一系列方法的调用生成并返回树
	 * @param rootId
	 * @param level
	 * @return
	 */
	public JSONArray factory(String rootId, int level){
		try{
			JSONArray materials= this.buildTree(rootId, level);
			JSONArray product = this.configTree(materials);
			return product;
		}catch(Exception e){
			logger.error("MenuTree factory error: "+ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}
	
	/**
	 * 遍历树 对树进行简单的加工
	 * @param array
	 * @return
	 */
	public JSONArray configTree(JSONArray array){
		JSONArray rebuild = null;
		if(array != null && !array.isEmpty()){
			rebuild = new JSONArray();
			for (int i = 0; i < array.size(); i++) {
				JSONObject tmp = array.getJSONObject(i);
				JSONObject node = new JSONObject();

				node.put("title", tmp.get("title"));
				node.put("level", tmp.get("level"));
				node.put("className", "");
				
				if(tmp.getBoolean("end")){
					node.put("accessKey", tmp.get("accessKey"));
					if(active == 0){
						node.put("active", true);
						active++;
					}
				}else{
					node.put("accessKey", "null");
					node.put("leftIconClass", tmp.get("leftIconClass"));
					node.put("titleClass", tmp.get("titleClass"));
					node.put("rightIconClass", tmp.get("rightIconClass"));
					
					if((int)tmp.get("level") == 1 && rootActive == 0){
						node.put("active", true);
						rootActive++;
					}
					
					JSONArray childrens = configTree(tmp.getJSONArray("childrens"));
					node.put("childrens", childrens);
					
				}
				
				rebuild.add(node);
			}
		}
		return rebuild;
	}
	
	/**
	 * 创建树 从根节点开始
	 * @param tree
	 * @param rootId
	 * @param level 默认从0开始
	 * @return
	 */
	public JSONArray buildTree(String rootId,int level){
		JSONArray array = null;
		List<SysMenu> list = getTreeNode(rootId);
		if(list != null && list.size() > 0){
			array = new JSONArray();
			for (int i = 0; i < list.size(); i++) {
				JSONObject node = new JSONObject();
				node.put("accessKey", list.get(i).getMenuUrl());
				node.put("title", list.get(i).getMenuName());
				node.put("level", level+1);
				node.put("className", list.get(i).getClassName());
				node.put("leftIconClass", list.get(i).getLeftIconClass());
				node.put("titleClass", list.get(i).getTitleClass());
				node.put("rightIconClass", list.get(i).getRightIconClass());
				List<SysMenu> subList = getTreeNode(list.get(i).getMenuId());
				
				//是否是最终子节点
				if(subList != null && subList.size() > 0){
					node.put("end", false);
					JSONArray childrens = buildTree(list.get(i).getMenuId(),level+1);
					node.put("childrens", childrens);
				}else{
					node.put("end", true);
				}
				
				//是否是根节点开始
				/*if(level == 0){
					node.put("root", true);
				}else{
					node.put("root", false);
				}*/
				
				array.add(node);
			}
		}
		return array;
	}
	 
	/**
	 * 获取某一节点的所有子节点
	 * @param nodeId
	 * @return
	 */
	public List<SysMenu> getTreeNode(String nodeId){
		List<SysMenu> nodes = new ArrayList<>();
		for (int i = 0; i < menus.size(); i++) {
			if(nodeId.equals(menus.get(i).getMenuPid())){
				nodes.add(menus.get(i));
			}
		}
		return nodes;
	}
	
}
