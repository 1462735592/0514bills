package com.pw.bills.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pw.bills.pojo.Bills;
import com.pw.bills.pojo.User;
import com.pw.bills.service.BillsService;
import com.pw.bills.utils.BillsVo;
import com.pw.bills.utils.LayuiData;

@Controller
public class ListController {
	@Autowired
	private BillsService billsService;
	@RequestMapping("list")
	public String showList() {
		return "list";
	}
	//获取所有的账单信息并进行分页
	@RequestMapping("/list/getAllBills")
	@ResponseBody
	public LayuiData getAllBills(BillsVo billsVo,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer userId = user.getId();
		LayuiData layuiData = billsService.getAllBills(userId,billsVo);
		//PageInfo<Bills> pageInfo = new PageInfo<>(billsList);
		return layuiData;
		
	}
	
}
