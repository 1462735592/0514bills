package com.pw.bills.service;

import java.util.List;

import com.pw.bills.pojo.BillsType;

public interface BillsTypeService {
	//查询所有账单类型数据
	public List<BillsType> getAll();
}
