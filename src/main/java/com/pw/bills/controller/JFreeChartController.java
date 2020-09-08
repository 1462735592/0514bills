package com.pw.bills.controller;

import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pw.bills.pojo.User;
import com.pw.bills.service.ColumnarService;
import com.pw.bills.service.PieService;

@Controller
public class JFreeChartController {
	@Autowired
	private ColumnarService columnarService;
	@Autowired
	private PieService pieService;
	
	@RequestMapping(value = "chart")
	public String showChart() {
		return "chart";
	}
	
	@RequestMapping(value = "getColumnChart")
	public void getColumnChart(HttpServletRequest request,
	        HttpServletResponse response, ModelMap modelMap) throws Exception {
	    // 在业务层获取创建的柱状图（此时柱状图已经创建完成的）
	    JFreeChart chart = columnarService.createColumnarTools();
	    // 将图形转换为图片传到dateSet.jsp
	    String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
	            null, request.getSession());
	    String chartURL = request.getServletContext().getRealPath("/images")+"/"+fileName;
	    FileOutputStream fileOutputStream = new FileOutputStream(chartURL);
	    ChartUtilities.writeChartAsJPEG(fileOutputStream,1,chart,700,400,null);
	   
	    
	    fileOutputStream.close();
	    modelMap.put("chartColumnURL", chartURL);
	   
	}
	@RequestMapping(value = "getPieChart")
	@ResponseBody
	public String getPieChart(HttpServletRequest request,
	        HttpServletResponse response, ModelMap modelMap,
	        HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		
	    // 在业务层获取创建的柱状图（此时柱状图已经创建完成的）
	    JFreeChart chart = pieService.createPieTools(user.getId());
	    // 将图形转换为图片传到dateSet.jsp
	    String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
	            null, request.getSession());
	    String chartURL = request.getServletContext().getRealPath("/images")+"/"+fileName;
	    FileOutputStream fileOutputStream = new FileOutputStream(chartURL);
	    ChartUtilities.writeChartAsJPEG(fileOutputStream,1,chart,700,400,null);
	   
	    
	    fileOutputStream.close();
	    modelMap.put("chartPieURL", chartURL);
	   return "images/"+fileName;
	}
	
}
