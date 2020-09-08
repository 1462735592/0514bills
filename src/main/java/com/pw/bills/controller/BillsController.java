package com.pw.bills.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pw.bills.pojo.Bills;
import com.pw.bills.pojo.User;
import com.pw.bills.service.BillsService;
import com.pw.bills.utils.Result;

@Controller
public class BillsController {
	@Autowired
	private BillsService billsService;
	
	//如何改账单存在则更新，如果不存在则添加
	@RequestMapping("addBill")
	@ResponseBody
	public Result addBill(Bills bills,HttpSession session,double price1) {
		//从session中获取用户信息
		User user = (User) session.getAttribute("user");
		Integer userId = user.getId();
		bills.setUserId(userId);
		Integer billsPrice = (int) (price1*100);
		bills.setPrice(billsPrice);
		//如果id不存在代表数据库里没有这个账单，则进行添加操作,
		//否则进行更新操作
		if(bills.getId()==null) {
			
			Result result = billsService.addBill(bills);
			return result;
		}
		else {
			Result result = billsService.updateBill(bills);
			return result;
		}
		
	}
	
	//根据id删除对应bills
	@RequestMapping("deleteBill")
	@ResponseBody
	public Result deleteBill(Integer id) {
		System.out.println(id);
		Result result = billsService.deleteBill(id);
		return result;
	}
}
