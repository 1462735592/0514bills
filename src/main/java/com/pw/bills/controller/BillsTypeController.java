package com.pw.bills.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pw.bills.pojo.Bills;
import com.pw.bills.pojo.BillsType;
import com.pw.bills.service.BillsTypeService;
import com.pw.bills.utils.Result;

@Controller
public class BillsTypeController {
	@Autowired
	private BillsTypeService billsTypeService;
	
	@RequestMapping("loadAllBillType")
	@ResponseBody
	public List<BillsType> getAllBills() {
		List<BillsType> all = billsTypeService.getAll();
		return all;
	}
	
}
