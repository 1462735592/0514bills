package com.pw.bills.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.bills.mapper.BillsTypeMapper;
import com.pw.bills.pojo.BillsType;
import com.pw.bills.pojo.BillsTypeExample;
import com.pw.bills.service.BillsTypeService;

@Service
public class BillsTypeServiceImpl implements BillsTypeService{
	@Autowired
	private BillsTypeMapper billsTypeMapper;
	@Override
	public List<BillsType> getAll() {
		BillsTypeExample example = new BillsTypeExample();
		List<BillsType> billsTypeList = billsTypeMapper.selectByExample(example );
		if(billsTypeList!=null&&billsTypeList.size()>0)
			return billsTypeList;
		return null;
	}

}
