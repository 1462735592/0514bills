package com.pw.bills.service;

import java.util.List;

import com.pw.bills.pojo.Bills;
import com.pw.bills.utils.BillsVo;
import com.pw.bills.utils.LayuiData;
import com.pw.bills.utils.Result;

public interface BillsService {
	public LayuiData getAllBills(Integer userId,BillsVo billsVo);

	public Result addBill(Bills bills);

	public Result deleteBill(Integer id);

	public int selectById(Bills bills);

	public Result updateBill(Bills bills);

	public List<Bills> getAllBIllsExcel(BillsVo billsVo, Integer userId);
}
