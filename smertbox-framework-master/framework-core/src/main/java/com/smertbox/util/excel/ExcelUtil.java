package com.smertbox.util.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExcelUtil {

	// 导出文件位置
	private static final String PATH = "d:/";
	// 导出字体
	private static final String FONT_NAME = "微软雅黑";
	// 文件后缀
	private static final String SUFFIX = ".xlsx";
	// 是否写到磁盘
	private static final boolean WRITE_LOCAL = true; 
	// 单元格对齐方式
	private static final short ALIGNMENT = HSSFCellStyle.ALIGN_CENTER;
	// 单元格颜色
	private static final short FILL_FOREGROUND_COLOR = IndexedColors.GREY_25_PERCENT.getIndex();
	// 单元格颜色填充方式
	private static final short FILL_PATTERN = CellStyle.SOLID_FOREGROUND;
	// 单元边框风格
	private static final short BORDER = XSSFCellStyle.BORDER_THIN;
	// 单元格边框颜色
	private static final short BORDER_COLOR = IndexedColors.BLACK.getIndex();
	
	private static DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 方法描述 : 将单个数据对象属性全部导出  如果表格标题长度和数据对象属性长度不一致时导出将失败.
	 * @param title
	 * @param sheetName
	 * @param list
	 * @return
	 */
	/*public static File export(String[] columns,String sheetName,List<?> list){
		String exportName = format.format(new Date()) + SUFFIX;
		String excelPath = PATH + File.separator + exportName;
		try {
			File file = new File(excelPath);
			OutputStream out = null;
			if(WRITE_LOCAL){
				out = new FileOutputStream(file);
			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(sheetName);
			sheet.setDefaultColumnWidth(20);
			createHeader(workbook, sheet, columns);
			XSSFCellStyle contentStyle = createContentStyle(workbook);

			JSONArray data = JSONArray.parseArray(JSONObject.toJSONString(list));
			for (int i = 0; i < data.size(); i++) {
				JSONObject object = data.getJSONObject(i);
				Set<String> set = object.keySet();
				if(set.size()>columns.length){
					throw new Exception("数据属性字段大于表格标题长度!");
				}
				int j = 0;
				XSSFRow dataRow = sheet.createRow(i+1);
				for(String key : set){
					XSSFCell cell = dataRow.createCell(j);
					cell.setCellValue(String.valueOf(object.getString(key)));
					cell.setCellStyle(contentStyle);
					j++;
				}
			}
			
			if(out!=null){
				workbook.write(out);
				out.close();
			}
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	/**
	 * 方法描述 : 按照设置的标题头和要导出的属性进行数据导出.
	 * @param title
	 * @param sheetName
	 * @param list
	 * @return
	 */
	public static File export(Map<String, String> columns,String sheetName,List<?> list){
		String exportName = format.format(new Date()) + SUFFIX;
		String excelPath = PATH + File.separator + exportName;
		try {
			File file = new File(excelPath);
			OutputStream out = null;
			if(WRITE_LOCAL){
				out = new FileOutputStream(file);
			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(sheetName);
			sheet.setDefaultColumnWidth(20);
			String[] titleArray = new String[columns.size()];
			String[] propertyArray = new String[columns.size()];
			int m = 0;
			for(Entry<String, String> entry : columns.entrySet()){
				titleArray[m] = entry.getKey();
				propertyArray[m] = entry.getValue();
				m++;
			}
			
			createHeader(workbook, sheet, titleArray);
			XSSFCellStyle contentStyle = createContentStyle(workbook);

			JSONArray data = JSONArray.parseArray(JSONObject.toJSONString(list));
			for (int i = 0; i < data.size(); i++) {
				JSONObject object = data.getJSONObject(i);
				XSSFRow dataRow = sheet.createRow(i+1);
				for(int j = 0;j < propertyArray.length;j++){
					XSSFCell cell = dataRow.createCell(j);
					cell.setCellValue(String.valueOf(object.getString(propertyArray[j])));
					cell.setCellStyle(contentStyle);
				}
			}

			if(out!=null){
				workbook.write(out);
				out.close();
			}
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 方法描述 : 创建标题头.
	 * @param sheet
	 * @param titleStyle
	 * @param headerList
	 * @return
	 */
	private static XSSFSheet createHeader(XSSFWorkbook workbook, XSSFSheet sheet, String[] header) {
		// 设置字体
		XSSFFont titleFont = workbook.createFont();
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		titleFont.setFontName(FONT_NAME);
		
		// 设置单元格样式
		XSSFCellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setFont(titleFont);
		titleStyle.setAlignment(ALIGNMENT);
		titleStyle.setFillForegroundColor(FILL_FOREGROUND_COLOR);
		titleStyle.setFillPattern(FILL_PATTERN);
		titleStyle.setBottomBorderColor(BORDER_COLOR);
		titleStyle.setBorderTop(BORDER);
		titleStyle.setBorderRight(BORDER);
		titleStyle.setBorderBottom(BORDER);
		titleStyle.setBorderLeft(BORDER);
		
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		for (int i = 0; i < header.length; i++) {
			XSSFCell cell = row.createCell(i);
			XSSFRichTextString text = new XSSFRichTextString(header[i]);
			cell.setCellValue(text);
			cell.setCellStyle(titleStyle);
		}
		return sheet;
	}
	
	private static XSSFCellStyle createContentStyle(XSSFWorkbook workbook){
		XSSFFont contentFont = workbook.createFont();
		contentFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		contentFont.setFontName(FONT_NAME);
		
		XSSFCellStyle contentStyle = workbook.createCellStyle();
		contentStyle.setAlignment(ALIGNMENT);
		contentStyle.setFont(contentFont);
		contentStyle.setBottomBorderColor(BORDER_COLOR);
		contentStyle.setBorderTop(BORDER);
		contentStyle.setBorderRight(BORDER);
		contentStyle.setBorderBottom(BORDER);
		contentStyle.setBorderLeft(BORDER);
		
		return contentStyle;
	}
}
