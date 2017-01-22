package com.smertbox.util.tree.model;

/**
 * Author : ladeng
 * Time: 2016年10月18日 下午10:55:48
 * Desc : 树节点数据模型
 */
public class TreeNode {

	private String id;
	
	private String pId;
	
	private String name;
	
	private String isParent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	
}
