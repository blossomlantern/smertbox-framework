package com.smertbox.util.page;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Author : ladeng
 * Time: 2016年9月14日 下午9:32:30
 * Desc : 分页工具类
 */
public class DataTablePageHelper {

	/**
	 * @description
	 * @param request
	 * @return 获取前台datatable插件传来的参数
	 * 返回的JSONArray包含前台列表页面显示的数据列分页、排序、搜索字段信息
	 * 	name-----------: 前台列表字段属性名称
	 *  searchable-----: 是否允许此列搜索
	 *  orderable------: 是否允许此列排序
	 */
	public JSONArray getParamArray(HttpServletRequest request){
		JSONArray array = new JSONArray();
		Map<String, String[]> columns = request.getParameterMap();
		int column = StringUtils.isNumeric(columns.get("column")[0])?Integer.parseInt(columns.get("column")[0]):0;
		for (int i = 0; i < column; i++) {
			JSONObject obj = new JSONObject();
			obj.put("name", columns.get("columns["+column+"][data]")[0]);
			obj.put("searchable", columns.get("columns["+column+"][searchable]")[0]);
			obj.put("orderable", columns.get("columns["+column+"][orderable]")[0]);
			array.add(obj);
		}
		return array;
	}
	
	/**
	 * @description
	 * @param request
	 * @return 返回要进行排序的字段列和排序方式
	 */
	public JSONObject getPageParams(HttpServletRequest request){
		JSONObject object = new JSONObject();
		Map<String, String[]> columns = request.getParameterMap();
		String[] i = columns.get("order[0][column]");
		if(i!=null&&i.length>0){
			String index = i[0];
			object.put("orderByClause", columns.get("columns["+index+"][data]")[0]);
			object.put("orderByType", columns.get("order[0][dir]")[0]);
		}
		return object;
	}
}
