package com.smertbox.security.resource.model;

/**
 * Author : ladeng
 * Time: 2016年9月20日 下午11:21:09
 * Desc : zTree 资源节点
 */
public class ResourceNode {

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
