package com.smertbox.util.page.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.smertbox.util.page.DataTablePageHelper;
import com.smertbox.util.string.CamelStyleUtil;

public class PageModel {

	// 每页行数
	private int length;
	// 开始行数
	private int start;
	// 排序字段
	private String orderByClause;
	// 排序方式
	private String orderByType;
	
	public void setPage(HttpServletRequest request){
		this.length = StringUtils.isNumeric(request.getParameter("length"))?Integer.parseInt(request.getParameter("length")):0;
		this.start = StringUtils.isNumeric(request.getParameter("start"))?Integer.parseInt(request.getParameter("start")):0;
		// 设置排序参数
		DataTablePageHelper dtph = new DataTablePageHelper();
		JSONObject object = dtph.getPageParams(request);
		this.orderByClause = CamelStyleUtil.camelToUnderline(object.getString("orderByClause"));
		this.orderByType = object.getString("orderByType");
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public String getOrderByType() {
		return orderByType;
	}
	public void setOrderByType(String orderByType) {
		this.orderByType = orderByType;
	}
	
}
