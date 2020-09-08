package com.pw.bills.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

public class BillsExprot<T> {

	public void getId(List<T> t,String path,String FileName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	   //创建工作簿
		HSSFWorkbook  workbook = new HSSFWorkbook();
	    //创建sheet
	    HSSFSheet sheet = workbook.createSheet(FileName);
	    //设置默认列宽
	    sheet.setDefaultColumnWidth(25);
	    //合并   参数1  开始行；参数2 结束行；参数3 开始列；参数4 结束列。
	    CellRangeAddress region = new CellRangeAddress(0,0,0,7);
		sheet.addMergedRegion(region);
		
		
		
		//第一行
		int row=0;
		HSSFRow row0 = sheet.createRow(0);
		//第一行第一个单元格
		HSSFCell cell00 = row0.createCell(0);
		cell00.setCellValue( FileName);
		//设置样式
		cell00.setCellStyle(createTitleStyle(workbook));
		
		//第二行
		row++;
		HSSFRow row1 = sheet.createRow(row);
		//设置样式
		HSSFCellStyle fieldStyle = createFieldStyle(workbook);
		Class<? extends Object> class1 = t.get(0).getClass();
		Field[] fields = class1.getDeclaredFields();
		//将属性一次放入第二行的每一个cell中
		for(int i=0;i<fields.length;i++) {
			fields[i].setAccessible(true);
			//属性name
			String name = fields[i].getName();
			HSSFCell cell = row1.createCell(i);
			cell.setCellValue(name);
			cell.setCellStyle(fieldStyle);
		}
		
		//第三到最后行
		row++;
		
		for (T t2 : t) {
			//创建行
			HSSFRow rowx = sheet.createRow(row++);
			
	    	Class tClass = t2.getClass();
	        //得到所有属性
	        Field[] field = tClass.getDeclaredFields();
	         for(int i=0;i<field.length;i++) {
	        	  //设置可以访问私有变量
			        field[i].setAccessible(true);
			        //获取属性的名字
			        String name = field[i].getName();
			        //将属性名字的首字母大写
			        name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
			        //整合出 getId() 属性这个方法
			        Method m = tClass.getMethod("get"+name);
			        //调用这个整合出来的get方法，强转成自己需要的类型
			        Object value = m.invoke(t2);
			        HSSFCell celli = rowx.createCell(i);
			        celli.setCellValue(value.toString());
			        celli.setCellStyle(createBaseStyle(workbook));
	         }
		}
		// 导出保存到D盘
		try {
			workbook.write(new File(path));
			System.out.println("导出成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//创建基础样式
	public static HSSFCellStyle createBaseStyle(HSSFWorkbook wb) {
		//基础样式
	    HSSFCellStyle baseCellStyle = wb.createCellStyle();
	    //设置水平 和 垂直居中
	    baseCellStyle.setAlignment(HorizontalAlignment.CENTER);
	    baseCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		return baseCellStyle;
	}
	//创建标题样式
	public static HSSFCellStyle createTitleStyle(HSSFWorkbook wb) {
		HSSFCellStyle titleStyle = createBaseStyle(wb);
		HSSFFont font = wb.createFont();
		font.setBold(true);
		font.setFontName("华文仿宋");
		font.setFontHeightInPoints((short)35);
		font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
		titleStyle.setFont(font);
		return titleStyle;
	}
	//字段样式
	public static HSSFCellStyle createFieldStyle(HSSFWorkbook wb) {
		HSSFCellStyle cellStyle = createBaseStyle(wb);
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short)30);
		font.setColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex());
		cellStyle.setFont(font);
		return cellStyle;
	}
}
