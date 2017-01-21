package com.smertbox.util.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : ladeng
 * Time: 2016年9月13日 下午8:40:11
 * Desc : datatables分页插件对应数据模型.
 */
public class DataTablePage {
	private List<?> data;// 查询结果集合
    private int recordsFiltered; // 过滤后的总行数
    private int recordsTotal;// 总记录数
    private int draw;// 防止CSRF
    private int start;// 开始行数
    private int length;// 页面行数
    private String error;// 错误提示信息
    
    public DataTablePage(){
    	this.data = new ArrayList<>();
    }
    
	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}

