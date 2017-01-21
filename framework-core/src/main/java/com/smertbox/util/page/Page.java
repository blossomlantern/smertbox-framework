package com.smertbox.util.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author : ladeng
 * Time: 2016年8月21日 下午4:14:02
 * Desc :分页对象
 */
public class Page {

	// 默认每页行数
	private final int default_page_size = 20;
	// 当前页
	private int pageNum;
	// 每页行数
	private int pageSize;
	// 开始行数
	private int beginRow;
	// 结束行数
	private int endRow;
	// 总行数
	private int totalRow;
	// 总页数
	private int totalPage;
	// 查询条件
	private Map<String, String> params; 
	// 数组查询条件
	private Map<String, List<String>> arrayParam;   
	// 结果集
	private List<?> data;
	
	public Page(){
		this.pageNum = 1;
		this.pageSize = this.default_page_size;
		this.beginRow = 0;
		this.endRow = 1;
		this.totalRow = 0;
		this.totalPage = 0;
		this.params = new HashMap<String, String>();
		this.arrayParam = new HashMap<String, List<String>>();
		this.data = new ArrayList<>();
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBeginRow() {
		return beginRow;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public long getTotalRow() {
		return totalRow;
	}
	public long getTotalPage() {
		return totalPage;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public Map<String, List<String>> getArrayParam() {
		return arrayParam;
	}

	public void setArrayParam(Map<String, List<String>> arrayParam) {
		this.arrayParam = arrayParam;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public int getDefault_page_size() {
		return default_page_size;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
